package default_package;

public class Laser extends Torre {

    public Laser(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 12;
        this.dano = 2;
        this.burn = false;
    }

    @Override
    void upgrade(){
        nivel += 1;
        vida += 4;
        dano += 1;
        if (nivel >= 3){
            burn = true;
        }
    }

}
