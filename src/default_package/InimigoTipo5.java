package default_package;

public class InimigoTipo5 extends Enemy{

    public InimigoTipo5(int linha, int lugar) {
        super(linha, lugar);
        this.vida = 26;
        this.dano = 5;
        this.velocidade = 2;
        this.valor = 10;
        this.resistente = true;
    }

    public void morrer(){
        if (this.vida <= 0){
            System.out.println("Inimigo morto");
            temVida = false;
        }
    }


    public void caminharDoElemento(){
        if (this.temVida){
            lugar -= this.velocidade;
        }
        if (lugar<0) {
            lugar=0;
        }
    }

    public int getPosicao(){
        return lugar;
    }

    public int getVida(){return vida;}

    public  int getValor(){return valor;}

    public void receberDano(int dano){vida -= dano;}

}
