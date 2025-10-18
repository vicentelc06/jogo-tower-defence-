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

            Caminho[] caminhos = new Caminho[3];

            for (int i = 0; i < 3; i++) {
                caminhos[i] = new Caminho(10);
            }
            //colocar o loop do jogo após o loop de "comprar" torres

            gerenciador.ondas(onda);
            while (base.vida > 0) {

                for (int i=0; i<10; i++){
                    if (gerenciador.monstros[i]!=null){
                        //gerenciador.monstros[i].caminharDoElemento(1);
                        if (gerenciador.monstros[i].getPosicao() == base.getPosicao())
                        {
                            base.receberDano(gerenciador.monstros[i].dano);
                        }
                        else{
                            gerenciador.monstros[i].caminharDoElemento(1);
                        }
                        //aqui dá pra fazer outro if que verifica a vida deles e quando ela chegar a 0 a gente esvazia a posição
                    }
                }

                for (int i = 0; i < 3; i++) {

                    for (int j = 0; j < gerenciador.monstros.length; j++) {
                        Enemy m = gerenciador.monstros[j];
                        if (m != null && m.linha == i) {
                            caminhos[i].colocarInimigo(m.getPosicao());
                        }
                    }
                    caminhos[i].exibir(); // exibe a linha depois de colocar todos os monstros
                }

                System.out.println("VIDA: "+base.vida+" MOEDAS: "+moeda.getMoeda());
                System.out.println("======================================");
                try {
                    Thread.sleep(1000); // 1000 ms = 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}




