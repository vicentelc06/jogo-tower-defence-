package default_package;

public class InimigoTipo5 extends Enemy{

    public InimigoTipo5(int linha, int lugar) {
        super(linha, lugar);
        this.vida = 26;
        this.dano = 5;
        this.velocidade = 2;
        this.valor = 10;
        this.resistente = true;
    }

}
