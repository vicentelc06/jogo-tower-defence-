package default_package;

public class Inimigo1 extends Enemy{


    public Inimigo1(int linha, int lugar) {
        super(linha, lugar);
        this.vida = 10;
        this.dano = 2;
        this.velocidade = 1;
    }

}
