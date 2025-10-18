package default_package;

public class Enemy {
    int vida;
    int dano;
    int linha;
    int lugar;

    public Enemy(int linha, int lugar){
        this.linha=linha;
        this.lugar = lugar;
        this.dano = 2;
    }

    //Posicao lugar = new Posicao(6,0);

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

}
