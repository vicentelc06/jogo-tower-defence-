package default_package;

public class Moeda {

    int quantidade;

    public Moeda(int quantidade){
        this.quantidade = quantidade;
    }
    void ganhar(int valor){
        this.quantidade+=valor;
    }

    int getMoeda(){
        return this.quantidade;
    }

}
