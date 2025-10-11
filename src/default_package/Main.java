package default_package;




public class Main {
//cara
    public static void main(String[] args) {

        Base base = new Base(10);
        Enemy zumbi = new Enemy(1);
        int tick = 0;

        Caminho[] caminhos = new Caminho[3];

        for (int i = 0; i < 3; i++) {
            caminhos[i] = new Caminho(10);
        }

        while (base.vida > 0) {

            if (zumbi.getPosicao() != base.getPosicao()) {

                System.out.println("tempo: " + tick);
                System.out.println("O inimigo está a " + zumbi.getPosicao() + " passos da sua base");
                System.out.println("A vida da base é: " + base.vida);
                zumbi.caminharDoElemento();

                for (int i = 0; i < 3; i++) {
                    if (i == zumbi.linha) {
                        caminhos[i].colocarInimigo(zumbi.getPosicao());
                    }
                    caminhos[i].exibir();
                }

                tick++;

                try {
                    Thread.sleep(1000); // 1000 ms = 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (zumbi.getPosicao() == base.getPosicao()) {

                System.out.println("tempo: " + tick);
                base.receberDano(zumbi.dano);
                System.out.println("A base recebeu dano!");
                System.out.println("A vida da base é: " + base.vida);
                tick++;

                try {
                    Thread.sleep(1000); // 1000 ms = 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("A base foi destruida!!");
    }
}

