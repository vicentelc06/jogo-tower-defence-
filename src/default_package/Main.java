package default_package;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.print("Digite 'S' para iniciar o jogo");
        String iniciar = scanner.nextLine();
        System.out.println("======================");


        if (iniciar.equalsIgnoreCase("s")) {

            Base base = new Base(10);
            int tick = 0;
            Moeda moeda = new Moeda(20);
            WaveManager gerenciador = new WaveManager();
            Torre[] torres = new Torre[100];
            int contTorres = 0;
            Disparo[] disparo = new Disparo[200];
            int contDisparo = 0;
            boolean rodando = true;

            Caminho[] caminhos = new Caminho[6];

            for (int i = 0; i < 6; i++) {
                caminhos[i] = new Caminho(14);
            }


            int contWaves = 1;
            while ((base.vida>0)&&(contWaves <10)) {


                System.out.println("======================");
                System.out.print("Digite '0' para comprar torres");
                int comprar = scanner.nextInt();
                System.out.println("======================");

                while (comprar == 0) {
                    System.out.println("Moedas: " + moeda.getMoeda());
                    System.out.println("Digite o tipo de torre desejada: ");
                    int tipo = scanner.nextInt();
                    switch (tipo) {
                        case 1:
                            if (moeda.comprar(5)) {
                                System.out.println("Linha: ");
                                int linhaDaTorre = scanner.nextInt() - 1;
                                while (linhaDaTorre < 0 || linhaDaTorre > 5) {
                                    System.out.println("Linha inválida. Tente novamente: ");
                                    linhaDaTorre = scanner.nextInt() - 1;
                                }
                                System.out.println("Coluna: ");
                                int colunaDaTorre = scanner.nextInt() - 1;
                                while (colunaDaTorre < 0 || colunaDaTorre > 2) {
                                    System.out.println("Coluna inválida. Tente novamente: ");
                                    colunaDaTorre = scanner.nextInt() - 1;
                                }
                                torres[contTorres] = new Laser(linhaDaTorre, colunaDaTorre);
                                contTorres++;
                            } else {
                                System.out.println("Diheiro insuficiente!");
                            }
                            break;
                        case 2:
                            if (moeda.comprar(3)) {
                                System.out.println("Linha: ");
                                int linhaDaTorre = scanner.nextInt() - 1;
                                while (linhaDaTorre < 0|| linhaDaTorre > 5) {
                                    System.out.println("Linha inválida. Tente novamente: ");
                                    linhaDaTorre = scanner.nextInt() - 1;
                                }
                                System.out.println("Coluna: ");
                                int colunaDaTorre = scanner.nextInt() - 1;
                                while (colunaDaTorre < 0 || colunaDaTorre > 2) {
                                    System.out.println("Coluna inválida. Tente novamente: ");
                                    colunaDaTorre = scanner.nextInt() - 1;
                                }
                                torres[contTorres] = new Inseticida(linhaDaTorre, colunaDaTorre);
                                contTorres++;
                            } else {
                                System.out.println("Diheiro insuficiente!");
                            }
                            break;
                        case 3:
                            if(moeda.comprar(4)){
                                int linhaDaTorre = scanner.nextInt() - 1;
                                while (linhaDaTorre < 0|| linhaDaTorre > 5) {
                                    System.out.println("Linha inválida. Tente novamente: ");
                                    linhaDaTorre = scanner.nextInt() - 1;
                                }
                                System.out.println("Coluna: ");
                                int colunaDaTorre = scanner.nextInt() - 1;
                                while (colunaDaTorre < 0 || colunaDaTorre > 2) {
                                    System.out.println("Coluna inválida. Tente novamente: ");
                                    colunaDaTorre = scanner.nextInt() - 1;
                                }
                                torres[contTorres] = new Raquete(linhaDaTorre, colunaDaTorre);
                                contTorres++;
                            }
                            else {
                                System.out.println("Dinehiro insuficiente!");
                            }
                            break;
                        default:
                            System.out.println("Tipo inválido ou indisponível.");
                    }
                    System.out.println("Moedas: " + moeda.getMoeda());
                    System.out.println("Digite '0' para comprar mais torres: ");
                    comprar = scanner.nextInt();
                }

                rodando = true;
                gerenciador.ondas(contWaves);


                while (base.vida > 0 && rodando) {
                    rodando = false;
                    tick ++;
                    for (int i = 0; i < 100; i++) {
                        if (gerenciador.monstros[i] != null) {
                            rodando = true;
                            boolean anda = true;

                            if (gerenciador.monstros[i].temVida) {
                                if (gerenciador.monstros[i].getPosicao() == base.getPosicao()) {
                                    base.receberDano(gerenciador.monstros[i].dano);
                                    anda = false;
                                } else {// ((gerenciador.monstros[i].getPosicao() == torres[i].getColuna()) && (torres[i].temVida) && (gerenciador.monstros[i].linha == torres[i].linha)) {
                                    for (int q=0;q<100;q++) {
                                        if ((torres[q] != null) && (gerenciador.monstros[i].linha == torres[q].linha) && (gerenciador.monstros[i].getPosicao() != torres[q].coluna) && (torres[q].temVida)){
                                            if (tick % 2 == 0){
                                                disparo[contDisparo] = new Disparo(torres[q].getLinha(), torres[q].getColuna(), torres[q].getDano());
                                                contDisparo++;
                                            }
                                            for(int c = 0; c < 200; c++){
                                                if (disparo[c] != null && disparo[c].emTransito){
                                                    disparo[c].andar();
                                                    if (disparo[c].atingir(gerenciador.monstros[i].getPosicao(), gerenciador.monstros[i].linha)){
                                                        gerenciador.monstros[i].receberDano(disparo[c].dano);
                                                        gerenciador.monstros[i].morrer();
                                                        System.out.println("Vida do inimigo: " + gerenciador.monstros[i].getVida());
                                                    }
                                                }
                                            }
                                        }
                                        else if((torres[q]!=null) && (gerenciador.monstros[i].getPosicao() == torres[q].getColuna()) && (torres[q].temVida) && (gerenciador.monstros[i].linha == torres[q].linha)) {
                                            gerenciador.monstros[i].receberDano(torres[q].dano);
                                            gerenciador.monstros[i].morrer();
                                            torres[q].receberDano(gerenciador.monstros[i].dano);
                                            torres[q].morrer();
                                            System.out.println("Vida da torre: " + torres[q].getVida());
                                            System.out.println("Vida do inimigo: " + gerenciador.monstros[i].getVida());
                                            anda = false;
                                        }
                                    }
                                }
                                if (anda==true) {
                                    gerenciador.monstros[i].caminharDoElemento();
                                }

                            } else {
                                moeda.ganhar(gerenciador.monstros[i].getValor());
                                gerenciador.monstros[i] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 6; i++) {
                        caminhos[i].limpar();
                        for (int j = 0; j < 100; j++) {

                            Disparo v = disparo[j];
                            if (v != null && v.linha == i) {
                                if (v.emTransito) {
                                    caminhos[i].colocarDisparo(v.getColuna());
                                }
                            }
                            Enemy m = gerenciador.monstros[j];
                            if (m != null && m.linha == i) {

                                if (m.temVida) {
                                    caminhos[i].colocarInimigo(m.getPosicao());
                                }
                            }
                            Torre r = torres[j];
                            if (r != null && r.linha == i) {
                                if (r.temVida) {
                                    caminhos[i].colocarTorre(r.getColuna());
                                }
                            }

                        }
                        caminhos[i].exibir(); // exibe contWaves linha depois de colocar todos os monstros
                    }

                    System.out.println("VIDA: " + base.vida + " MOEDAS: " + moeda.getMoeda());
                    System.out.println("======================================");
                    try {
                        Thread.sleep(1000); // 1000 ms = 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                contWaves++;

            }
            if (contWaves <=10){
                System.out.println("você perdeu!!");
            }
            else{
                System.out.print("Você ganhou!");
            }

        }
    }
}




