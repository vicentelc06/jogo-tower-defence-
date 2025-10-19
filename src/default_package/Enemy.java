package default_package;

public class Enemy {
    int vida;
    int dano;
    int linha;
    int lugar;
    boolean temVida;

    public Enemy(int linha, int lugar){
        this.linha=linha;
        this.lugar = lugar;
        this.dano = 2;
        this.temVida = true;
    }

    //Posicao lugar = new Posicao(6,0);

    void morrer(){
        if (this.vida <= 0){
            System.out.println("Inimigo morto");
            temVida = false;
        }
    }

    void caminharDoElemento(int velocidade){
        //lugar.x-= velocidade;
        lugar -= velocidade;
        if (lugar<0) {
            lugar=0;
        }
    }

    int getPosicao(){
       // return lugar.x;
        return lugar;
    }

    int getDano(){
        return dano;
    }

    void receberDano(int dano){vida -= dano;}

}
