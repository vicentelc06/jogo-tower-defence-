package default_package;

public class Enemy {
    int vida;
    int dano;
    int linha;
    int lugar;
    boolean temVida;
    int velocidade;

    public Enemy(int linha, int lugar){
        this.linha=linha;
        this.lugar = lugar;
        this.temVida = true;
    }

    void morrer(){
        if (this.vida <= 0){
            System.out.println("Inimigo morto");
            temVida = false;
        }
    }

    void caminharDoElemento(){
        lugar -= this.velocidade;
        if (lugar<0) {
            lugar=0;
        }
    }

    int getPosicao(){
        return lugar;
    }

    int getVida(){return vida;}

    void receberDano(int dano){vida -= dano;}

}
