package default_package;

public class Torre {
    int vida;
    int linha;
    int coluna;
    int dano;
    boolean temVida;

    public Torre(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.temVida = true;
    }

    void morrer(){
        if(this.vida <= 0){
            this.temVida = false;
        }
    }

    void receberDano(int dano){vida -= dano;}

    int getColuna(){return coluna;}
    int getLinha(){return linha;}
    int getVida(){return vida;}
    int getDano(){return dano;}
}


