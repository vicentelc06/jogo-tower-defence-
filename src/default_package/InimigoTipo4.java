package default_package;

public class InimigoTipo4 extends Enemy{


    public InimigoTipo4(int linha, int lugar) {
        super(linha, lugar);
        this.vida = 12;
        this.dano = 3;
        this.velocidade = 1;
        this.valor = 4;
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
