package default_package;

public class Disparo{

    boolean emTransito;
    int linha;
    int coluna;
    int dano;

    public Disparo(int linha, int coluna, int dano) {
        this.linha = linha;
        this.coluna = coluna;
        this.dano = dano;
        this.emTransito = true;
    }

    void andar(){
        this.coluna ++;
    }

    boolean atingir(int colunaDoInimigo, int linhaDoInimigo){
        if (this.coluna >= colunaDoInimigo && this.linha == linhaDoInimigo){
            this.emTransito = false;
            return true;
        }
        else {
            return false;
        }
    }

}
