package default_package;



public class Base {
	int vida;

    Posicao casinha = new Posicao(0,0);
	
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
        return casinha.x;
    }
}
