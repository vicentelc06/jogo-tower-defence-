package default_package;

public class TorreTipo1 extends Torre {

    int custo;

    public TorreTipo1(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 10;
        this.dano = 2;
        this.custo = 4;
    }

}
