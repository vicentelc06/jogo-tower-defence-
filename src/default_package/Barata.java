package default_package;

public class Barata extends Enemy{


    public Barata(int linha, int lugar) {
        super(linha, lugar);
        this.vida = 16;
        this.dano = 2;
        this.velocidade = 1;
        this.valor = 4;
    }

}
