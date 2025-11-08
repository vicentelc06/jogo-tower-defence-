package default_package;

public class Raquete extends Torre{

    int custo;

    public Raquete(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 8;
        this.dano = 2;
        this.custo = 4;
    }
}
