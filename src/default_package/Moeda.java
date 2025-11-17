package default_package;

public class Moeda {

    int quantidade;

    public Moeda(int quantidade){
        this.quantidade = quantidade;
    }

    void ganhar(int valor){
        this.quantidade+=valor;
    }

    void comprar(int custo){
        if(custo > quantidade) {
            throw new RuntimeException("Dinheiro insuficiente.");
        }
        this.quantidade -= custo;
    }

    int getMoeda(){
        return this.quantidade;
    }

}
