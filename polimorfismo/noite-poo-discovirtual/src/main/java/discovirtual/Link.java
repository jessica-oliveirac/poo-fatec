package discovirtual;

public class Link extends ItemSistemaArquivo {

    private String url;
    
    public Link(Pasta pastaPai, String nome, String url) {
        super(nome, pastaPai);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int getTamanho() {
        // Busca o tamanho do link na URL em questão
        // ...
        return 0;
    }
    
}
