package default_package;

public class Raquete extends Torre{

    int custo;

    public Raquete(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 10;
        this.dano = 4;
        this.custo = 4;
    }
}
