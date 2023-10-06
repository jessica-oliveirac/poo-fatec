package discovirtual;

import java.util.ArrayList;

public abstract class ItemSistemaArquivo {
    private String nome;
    private Pasta pastaPai;

    public ItemSistemaArquivo(String nome) {
        setNome(nome);
    }

    public ItemSistemaArquivo(String nome, Pasta pastaPai) {
        setNome(nome);
        setPastaPai(pastaPai);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pasta getPastaPai() {
        return pastaPai;
    }
    
    private void setPastaPai(Pasta pai) {
        this.pastaPai = pai;
    }
    
     public ArrayList<Pasta> getCaminhoDesdeRaiz() {
        ArrayList<Pasta> caminho = new ArrayList<>();
        Pasta pastaAtual = pastaPai;
        while (pastaAtual != null) {
            caminho.add(0, pastaAtual);
            pastaAtual = pastaAtual.getPastaPai();
        }
        return caminho;
    }
     
    public abstract int getTamanho();
    
}
