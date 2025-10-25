package default_package;

public class Caminho {

    char[] trilha;
    int tamanho;
    int inim = 0;
    Enemy[] monstro = new Enemy[100];

    public Caminho(int tamanho) {
        this.tamanho = tamanho;
        trilha = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            trilha[i] = '.';
        }
    }

    public void colocarInimigo(int posicao) {
        trilha[posicao] = 'Z';
    }

    public void colocarTorre(int coluna){
        trilha[coluna] = 'T';
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

    public void invocar(int linha, int lugar){

        monstro[inim] = new Enemy(linha,lugar);
        inim++;

    }

}
