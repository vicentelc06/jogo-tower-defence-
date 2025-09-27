package default_package;




public class Main {

    public static void main(String[] args) {

        Base base = new Base(10);
        Enemy zumbi = new Enemy();

    while(base.vida >0)

        {

            if (zumbi.getPosicao() != base.getPosicao()) {

                System.out.println("O inimigo está a " + zumbi.getPosicao() + " passos da sua base");
                System.out.println("A vida da base é: " + base.vida);
                zumbi.caminharDoElemento();

            } else if (zumbi.getPosicao() == base.getPosicao()) {

                base.receberDano(zumbi.dano);
                System.out.println("A base recebeu dano!");
                System.out.println("A vida da base é: " + base.vida);
            }

        }
        System.out.println("A base foi destruida!!");
    }
}