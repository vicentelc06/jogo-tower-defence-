package default_package;
import java.util.Scanner;



public class Main {
    //cara
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.print("Digite 'S' para iniciar o jogo");
        String iniciar = scanner.nextLine();
        System.out.println("======================");


        if (iniciar.equalsIgnoreCase("s")) {

            Base base = new Base(10);
            int tick = 0;
            Moeda moeda = new Moeda(10);
            int onda = 1;
            WaveManager gerenciador = new WaveManager();
            Torre[] torres = new Torre[100];
            int t = 0;
            boolean rodando = true;

            Caminho[] caminhos = new Caminho[3];

            for (int i = 0; i < 3; i++) {
                caminhos[i] = new Caminho(10);
            }


            int a = 0;
            while ((base.vida>0)&&(a<4)) {


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
                            if (moeda.comprar(4)) {
                                System.out.println("Linha: ");
                                int linhaDaTorre = scanner.nextInt() - 1;
                                while (linhaDaTorre < 0 || linhaDaTorre > 2) {
                                    System.out.println("Linha inválida. Tente novamente: ");
                                    linhaDaTorre = scanner.nextInt() - 1;
                                }
                                System.out.println("Coluna: ");
                                int colunaDaTorre = scanner.nextInt() - 1;
                                while (colunaDaTorre < 0 || colunaDaTorre > 2) {
                                    System.out.println("Coluna inválida. Tente novamente: ");
                                    colunaDaTorre = scanner.nextInt() - 1;
                                }
                                torres[t] = new TorreTipo1(linhaDaTorre, colunaDaTorre);
                                t++;
                            } else {
                                System.out.println("Diheiro insuficiente!");
                            }
                            break;
                        case 2:
                            if (moeda.comprar(3)) {
                                System.out.println("Linha: ");
                                int linhaDaTorre = scanner.nextInt() - 1;
                                while (linhaDaTorre < 0|| linhaDaTorre > 2) {
                                    System.out.println("Linha inválida. Tente novamente: ");
                                    linhaDaTorre = scanner.nextInt() - 1;
                                }
                                System.out.println("Coluna: ");
                                int colunaDaTorre = scanner.nextInt() - 1;
                                while (colunaDaTorre < 0 || colunaDaTorre > 2) {
                                    System.out.println("Coluna inválida. Tente novamente: ");
                                    colunaDaTorre = scanner.nextInt() - 1;
                                }
                                torres[t] = new TorreTipo2(linhaDaTorre, colunaDaTorre);
                                t++;
                            } else {
                                System.out.println("Diheiro insuficiente!");
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
                gerenciador.ondas(a);

                while (base.vida > 0 && rodando) {
                    rodando = false;
                    for (int i = 0; i < 10; i++) {
                        if (gerenciador.monstros[i] != null) {
                            rodando = true;
                            boolean anda = true;

                            if (gerenciador.monstros[i].temVida) {
                                if (gerenciador.monstros[i].getPosicao() == base.getPosicao()) {
                                    base.receberDano(gerenciador.monstros[i].dano);
                                    anda = false;
                                } else {// ((gerenciador.monstros[i].getPosicao() == torres[i].getColuna()) && (torres[i].temVida) && (gerenciador.monstros[i].linha == torres[i].linha)) {
                                    for (int q=0;q<100;q++) {
                                        if ((torres[q]!=null) && (gerenciador.monstros[i].getPosicao() == torres[q].getColuna()) && (torres[q].temVida) && (gerenciador.monstros[i].linha == torres[q].linha)) {
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
                                gerenciador.monstros[i] = null;
                                moeda.ganhar(6);
                            }
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        caminhos[i].limpar();
                        for (int j = 0; j < 100; j++) {
                            Enemy m = gerenciador.monstros[j];
                            //caminhos[i].limpar();
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
                        caminhos[i].exibir(); // exibe a linha depois de colocar todos os monstros
                    }

                    System.out.println("VIDA: " + base.vida + " MOEDAS: " + moeda.getMoeda());
                    System.out.println("======================================");
                    try {
                        Thread.sleep(1000); // 1000 ms = 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a++;

            }
            if (a<=3){
                System.out.println("você perdeu!!");
            }
            else{
                System.out.print("Você ganhou!");
            }

        }
    }
}




