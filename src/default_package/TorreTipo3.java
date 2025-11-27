package default_package;

public class TorreTipo3 extends Torre{



    public TorreTipo3(int linha, int coluna) {
        super(linha, coluna);
        this.vida = 10;
        this.dano = 4;
    }


    public  void morrer(){
        if(this.vida <= 0){
            this.temVida = false;
        }
    }

    public void upgrade(){
        nivel += 1;
        vida += 4;
        dano += 1;
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
