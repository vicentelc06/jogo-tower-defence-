package default_package;

public class Enemy {
    int vida = 10;
    int dano = 2;
    int linha;

    public Enemy(int linha){
        this.linha=linha;
    }

    Posicao lugar = new Posicao(5,0);

    void caminharDoElemento(){
         lugar.x--;
    }

    int getPosicao(){
        return lugar.x;
    }

}
