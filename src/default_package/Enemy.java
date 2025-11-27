package default_package;

public abstract class Enemy {
    int vida;
    int dano;
    int linha;
    int lugar;
    boolean temVida;
    int velocidade;
    int valor;
    boolean queimado;
    boolean resistente;

    public Enemy(int linha, int lugar){
        this.linha=linha;
        this.lugar = lugar;
        this.temVida = true;
        this.resistente = false;

    }

   public abstract void morrer();

    public abstract void caminharDoElemento();

    public abstract int getPosicao();

    public abstract int getVida();

    public abstract int getValor();

    public abstract void receberDano(int dano);

}
