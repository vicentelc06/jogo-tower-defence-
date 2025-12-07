package default_package;

import javax.swing.*;
import java.awt.event.*;

public class GameEngine {

    public Base base;
    public Moeda moeda;
    public WaveManager gerenciador;
    public Torre[] torres;
    public Disparo[] disparos;
    public Caminho[] caminhos;
    public int contTorres = 0;
    public int contDisparo = 0;
    public int tick = 0;
    public int contWaves = 1;
    public boolean waveRunning = false;
    public Timer timer;

    public GameEngine() {
        base = new Base(10);
        moeda = new Moeda(20);
        gerenciador = new WaveManager();

        torres = new Torre[200];
        disparos = new Disparo[200];

        caminhos = new Caminho[6];
        for (int i = 0; i < 6; i++) {
            caminhos[i] = new Caminho(14);
        }
    }

    public void iniciarLoop(GamePanel panel) {
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
                panel.repaint();
            }
        });
        timer.start();
    }

    public void startNextWave() {
        gerenciador.ondas(contWaves);
        waveRunning = true;
    }

    public void buyTower(int tipo, int linha, int coluna) throws RuntimeException {
        switch (tipo) {
            case 1:
                moeda.comprar(Constantes.CUSTO_TORRE_1);
                torres[contTorres] = new TorreTipo1(linha, coluna);
                contTorres++;
                break;
            case 2:
                moeda.comprar(Constantes.CUSTO_TORRE_2);
                torres[contTorres] = new TorreTipo2(linha, coluna);
                contTorres++;
                break;
            case 3:
                moeda.comprar(Constantes.CUSTO_TORRE_3);
                torres[contTorres] = new TorreTipo3(linha, coluna);
                contTorres++;
                break;
            default:
                throw new RuntimeException("Tipo de torre inválido.");
        }
    }

    public void upgradeTowerAt(int linha, int coluna) throws RuntimeException {
        boolean encontrada = false;

        for (int i = 0; i < torres.length; i++) {
            Torre t = torres[i];
            if (t != null) {
                if (t.linha == linha && t.coluna == coluna) {
                    encontrada = true;
                    t.validarUpgradePossivel();
                    moeda.comprar(Constantes.CUSTO_UPGRADE);
                    t.upgrade();
                    return;
                }
            }
        }
        if (!encontrada) throw new RuntimeException("Torre não encontrada para upgrade.");
    }

    public boolean isGameOver() {
        return base.vida <= 0;
    }

    public boolean hasWon() {
        return contWaves >= 10;
    }

    public void tick() {

        if (!waveRunning) return;

        tick++;
        boolean rodando = false;

        for (int i = 0; i < 100; i++) {
            Enemy enemy = gerenciador.monstros[i];
            if (enemy != null) {
                rodando = true;
                boolean anda = true;

                if (enemy.temVida) {

                    if ((enemy.queimado) && (!enemy.resistente)) {
                        enemy.receberDano(1);
                    }

                    if (enemy.getPosicao() == base.getPosicao()) {

                        for (int q = 0; q < 100; q++) {
                            if ((torres[q] != null) && (torres[q].temVida)) {
                                if ((enemy.linha == torres[q].linha) &&
                                        (enemy.getPosicao() <= torres[q].getColuna())) {
                                    enemy.lugar = torres[q].getColuna();
                                }
                            }
                        }
                        if (enemy.getPosicao() == base.getPosicao()) {
                            base.receberDano(enemy.dano);
                        }
                        anda = false;

                    } else {

                        for (int q = 0; q < 100; q++) {
                            if ((torres[q] != null) &&
                                    (enemy != null) &&
                                    (enemy.linha == torres[q].linha) &&
                                    (enemy.getPosicao() != torres[q].coluna) &&
                                    (torres[q].temVida)) {

                                if (tick % 2 == 0) {
                                    if (contDisparo < disparos.length) {
                                        disparos[contDisparo] = new Disparo(
                                                torres[q].getLinha(),
                                                torres[q].getColuna(),
                                                torres[q].getDano(),
                                                torres[q].burn
                                        );
                                        contDisparo++;
                                    }
                                }

                                for (int c = 0; c < 200; c++) {
                                    if (disparos[c] != null && disparos[c].emTransito) {
                                        disparos[c].andar();

                                        if (disparos[c].getColuna() >= 14) {
                                            disparos[c] = null;
                                        }

                                        if ((disparos[c] != null) &&
                                                disparos[c].atingir(enemy.getPosicao(), enemy.linha)) {

                                            enemy.receberDano(disparos[c].dano);
                                            enemy.morrer();

                                            if ((disparos[c].burn) && (!enemy.queimado)) {
                                                enemy.queimado = true;
                                            }
                                        }
                                    }
                                }
                            }
                            else if ((torres[q] != null) &&
                                    (enemy != null) &&
                                    (enemy.getPosicao() <= torres[q].getColuna()) &&
                                    (torres[q].temVida) &&
                                    (enemy.linha == torres[q].linha)) {

                                if (enemy.getPosicao() < torres[q].getColuna()) {
                                    enemy.lugar = torres[q].getColuna();
                                }

                                enemy.receberDano(torres[q].dano);
                                enemy.morrer();
                                torres[q].receberDano(enemy.dano);
                                torres[q].morrer();
                                anda = false;
                            }
                        }
                    }

                    if (anda) {
                        enemy.caminharDoElemento();
                    }

                } else {
                    moeda.ganhar(enemy.getValor());
                    gerenciador.monstros[i] = null;
                }
            }
        }

        // atualiza os caminhos — SEM PRINTS
        for (int i = 0; i < 6; i++) {
            caminhos[i].limpar();

            for (int j = 0; j < 200; j++) {

                Disparo v = disparos[j];
                if (v != null && v.linha == i && v.emTransito) {
                    caminhos[i].colocarDisparo(v.getColuna());
                }

                Enemy m = gerenciador.monstros[j];
                if (m != null && m.temVida && m.linha == i) {
                    caminhos[i].colocarInimigo(m.getPosicao());
                }

                Torre r = torres[j];
                if (r != null && r.temVida && r.linha == i) {
                    caminhos[i].colocarTorre(r.getColuna());
                }
            }
        }

        // fim da onda
        boolean anyAlive = false;
        for (int i = 0; i < gerenciador.monstros.length && i < 100; i++) {
            Enemy m = gerenciador.monstros[i];
            if (m != null && m.temVida) {
                anyAlive = true;
                break;
            }
        }

        if (!anyAlive) {
            waveRunning = false;
            contWaves++;
        }
    }

    public Caminho[] getCaminhos() { return caminhos; }
    public Base getBase() { return base; }
    public Moeda getMoeda() { return moeda; }
    public int getCurrentWave() { return contWaves; }
}
