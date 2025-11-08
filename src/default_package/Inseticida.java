package default_package;

public class Inseticida extends Torre{

    int custo;

    public Inseticida(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 6;
        this.dano = 1;
        this.custo = 3;
    }
}
