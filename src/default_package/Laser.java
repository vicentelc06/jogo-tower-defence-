package default_package;

public class Laser extends Torre {

    int custo;

    public Laser(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 10;
        this.dano = 2;
        this.custo = 5;
    }

}
