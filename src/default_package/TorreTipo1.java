package default_package;

public class TorreTipo1 extends Torre {

    public TorreTipo1(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 12;
        this.dano = 2;
        this.burn = false;
    }

    public void upgrade(){
        nivel += 1;
        vida += 4;
        dano += 1;
        if (nivel >= 3){
            burn = true;
        }
    }


    public  void morrer(){
        if(this.vida <= 0){
            this.temVida = false;
        }
    }

    public  void receberDano(int dano){vida -= dano;}

    public  void validarUpgradePossivel(){
        if(this.nivel >= Constantes.NIVEL_MAXIMO_TORRES){
            throw new RuntimeException("Torre já está no nível máximo.");
        }
    }


    public  int getColuna(){return coluna;}
    public  int getLinha(){return linha;}
    public   int getVida(){return vida;}
    public   int getDano(){return dano;}
}


