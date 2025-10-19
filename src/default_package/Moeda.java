package default_package;

public class Moeda {

    int quantidade;

    public Moeda(int quantidade){
        this.quantidade = quantidade;
    }

    void ganhar(int valor){
        this.quantidade+=valor;
    }

    boolean comprar(int custo){
        if(custo > quantidade){
            System.out.println("Diheiro insuficiente!");
            return false;
        }
        else{
            this.quantidade -= custo;
            return true;
        }
    }

    int getMoeda(){
        return this.quantidade;
    }

}
