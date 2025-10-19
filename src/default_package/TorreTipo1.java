package default_package;

public class TorreTipo1 extends Torre {

    int dano;
    int custo;

    public TorreTipo1(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 12;
        this.dano = 2;
        this.custo = 4;
    }

}
