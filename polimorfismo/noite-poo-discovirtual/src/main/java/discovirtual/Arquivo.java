package discovirtual;

public class Arquivo extends ItemSistemaArquivo {
    private int tamanho;

    public Arquivo(Pasta pasta, String nome, int tamanho) {
        super(nome, pasta);
        setTamanho(tamanho);
    }

    public int getTamanho() {
        return tamanho;
    }

    private void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
