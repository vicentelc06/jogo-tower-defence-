package default_package;

public class Caminho {

    char[] trilha;
    int tamanho;

    public Caminho(int tamanho) {
        this.tamanho = tamanho;
        trilha = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            trilha[i] = '.';
        }
    }

    public void colocarInimigo(int posicao) {
        limpar();
        trilha[posicao] = 'Z';
    }

    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            trilha[i] = '.';
        }
    }

    public void exibir() {
        for (char c : trilha) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
