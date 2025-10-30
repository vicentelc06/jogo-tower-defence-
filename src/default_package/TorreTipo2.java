package default_package;

public class TorreTipo2 extends Torre{

    int custo;
    int alcance = 5;

    public TorreTipo2(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 6;
        this.dano = 1;
        this.custo = 3;
        this.alcance=5;
    }
}
