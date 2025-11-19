package default_package;



public class Base {
	int vida;
    int lugar = 0;
	
	Base (int vida){
		this.vida = vida;
	}

	void receberDano(int dano) {
		vida -= dano;
	}
	
    int getVida() {
	        return vida;
	    }

    int getPosicao(){
        return lugar;
    }
}
