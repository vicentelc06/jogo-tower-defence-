package default_package;

public abstract class Torre {
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

   public abstract void morrer();

    public abstract void receberDano(int dano);

    public abstract void validarUpgradePossivel();

    public abstract void upgrade();

    public abstract int getColuna();
    public abstract int getLinha();
    public abstract  int getVida();
    public abstract  int getDano();
}


