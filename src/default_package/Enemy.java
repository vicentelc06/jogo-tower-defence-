package default_package;

public class Enemy {
    int vida;
    int dano;
    int linha;

    public Enemy(int linha){
        this.linha=linha;
    }

    Posicao lugar = new Posicao(6,0);

    void caminharDoElemento(){
         lugar.x--;
    }

    int getPosicao(){
        return lugar.x;
    }

}
