package default_package;

public class Torre {
    int vida;
    int linha;
    int coluna;
    int dano;
    boolean temVida;
    int nivel;
    boolean burn;

    public Torre(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.temVida = true;
        this.nivel = 1;
        this.burn = false;
    }

    void morrer(){
        if(this.vida <= 0){
            this.temVida = false;
        }
    }

    void receberDano(int dano){vida -= dano;}

    void upgrade(){
        nivel =+ 1;
        vida =+ 4;
        dano =+ 1;
    }

    int getColuna(){return coluna;}
    int getLinha(){return linha;}
    int getVida(){return vida;}
    int getDano(){return dano;}
}


