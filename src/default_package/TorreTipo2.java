package default_package;

public class TorreTipo2 extends Torre{

    int custo;

    public TorreTipo2(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 6;
        this.dano = 1;
        this.custo = 3;
    }
}
