package default_package;

public class Base {
	int vida;
	
	Base (int vida){
		this.vida = vida;
	}

	void receberDano(int dano) {
		vida -= dano;
	}
	
	 int getVida() {
	        return vida;
	    }
}
