package default_package;

public class Caminho {

    char[] trilha;
    public int tamanho;
    int inim = 0;
    Enemy[] monstro = new Enemy[100];

    public int[] tipoTorre;    // 0=nenhuma, 1=t1, 2=t2, 3=t3
    public int[] tipoInimigo;  // 0=nenhum, 1=normal, 2=rápido, 3=boss...


    public Caminho(int tamanho) {
        this.tamanho = tamanho;
        trilha = new char[tamanho];
        tipoTorre = new int[tamanho];
        tipoInimigo = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            trilha[i] = '.';
            tipoTorre[i] = 0;
            tipoInimigo[i] = 0;
        }
    }

    public void colocarInimigo(int posicao) {
        trilha[posicao] = 'Z';
    }

    public void colocarTorre(int coluna){
        trilha[coluna] = 'T';
        //tipoTorre[coluna] = tipo;
    }

    public void colocarDisparo(int coluna){
        trilha[coluna] = '>';
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

    public char[] getTrilha() {
        return trilha;
    }



}
