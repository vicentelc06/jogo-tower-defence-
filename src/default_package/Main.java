package default_package;




public class Main {
//cara
    public static void main(String[] args) {

        Base base = new Base(10);
        Inimigo1 monstro = new Inimigo1(1);
        Inimigo2 monstrinho = new Inimigo2(2);
        int tick = 0;

        Caminho[] caminhos = new Caminho[3];

        for (int i = 0; i < 3; i++) {
            caminhos[i] = new Caminho(10);
        }

        while (base.vida > 0) {

            if ((monstro.getPosicao() != base.getPosicao()) && (monstrinho.getPosicao() != base.getPosicao())){

                System.out.println("tempo: " + tick);
                System.out.println("O monstro está a " + monstro.getPosicao() + " passos da sua base");
                System.out.println("O monstrinho está a " + monstrinho.getPosicao() + " passos da sua base");
                System.out.println("A vida da base é: " + base.vida);
                monstro.caminharDoElemento();
                monstrinho.caminharDoElemento();

                for (int i = 0; i < 3; i++) {
                    if (i == monstro.linha) {
                        caminhos[i].colocarInimigo(monstro.getPosicao());
                    }
                    if (i == monstrinho.linha){
                        caminhos[i].colocarInimigo(monstrinho.getPosicao());
                    }
                    caminhos[i].exibir();
                }

                tick++;

                try {
                    Thread.sleep(1000); // 1000 ms = 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if ((monstrinho.getPosicao() == base.getPosicao()) && monstro.getPosicao() != base.getPosicao()) {

                System.out.println("tempo: " + tick);
                base.receberDano(monstrinho.dano);
                System.out.println("A base recebeu dano!");
                System.out.println("A vida da base é: " + base.vida);
                System.out.println("O monstro está a " + monstro.getPosicao() + " passos da sua base");
                monstro.caminharDoElemento();

                for (int i = 0; i < 3; i++){
                    if(i == monstro.linha){
                        caminhos[i].colocarInimigo(monstro.getPosicao());
                    }
                    caminhos[i].exibir();
                }

                tick++;

                try {
                    Thread.sleep(1000); // 1000 ms = 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            else if ((monstro.getPosicao() == base.getPosicao()) && (monstrinho.getPosicao() == base.getPosicao())){

                System.out.println("tempo: " + tick);
                base.receberDano(monstro.dano);
                base.receberDano(monstrinho.dano);
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

