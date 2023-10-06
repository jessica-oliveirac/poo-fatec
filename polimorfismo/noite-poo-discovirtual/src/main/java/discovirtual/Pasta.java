package discovirtual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pasta extends ItemSistemaArquivo {
    private final ArrayList<ItemSistemaArquivo> filhos = new ArrayList<>();

    public Pasta(String nome) {
        super(nome);
    }
    
    public Pasta(String nome, Pasta pastaPai) {
        super(nome, pastaPai);
    }

    public boolean eRaiz() {
        return getPastaPai() == null;
    }

    public List<Pasta> getSubPastas() {
        return filhos
                .stream()
                .filter(it -> it instanceof Pasta)
                .map(it -> (Pasta) it)
                .collect(Collectors.toList());
    }

    public List<Arquivo> getArquivos() {
        return filhos
                .stream()
                .filter(it -> it instanceof Arquivo)
                .map(it -> (Arquivo) it)
                .collect(Collectors.toList());
    }

    public void addPasta(Pasta subPasta) {
        if (temFilhoComNome(subPasta.getNome())) {
            throw new IllegalArgumentException("Já existe um outro item com este nome");
        }
        filhos.add(subPasta);
    }

    public Pasta novaSubPasta(String nome) {
        if (temFilhoComNome(nome)) {
            throw new IllegalArgumentException("Já existe um outro item com este nome");
        }
        Pasta subPasta = new Pasta(nome, this);
        filhos.add(subPasta);
        return subPasta;
    }

    public void addArquivo(Arquivo arquivo) {
        if (temFilhoComNome(arquivo.getNome())) {
            throw new IllegalArgumentException("Já existe um outro item com este nome");
        }
        filhos.add(arquivo);
    }

    public Arquivo novoArquivo(String nome, int tamanho) {
        if (temFilhoComNome(nome)) {
            throw new IllegalArgumentException("Já existe um outro item com este nome");
        }
        Arquivo arquivo = new Arquivo(this, nome, tamanho);
        filhos.add(arquivo);
        return arquivo;
    }

    public long quantasSubPastas() {
        return filhos
                .stream()
                .filter(it -> it instanceof Pasta)
                .count();
    }

    public long quantosArquivos() {
        return filhos
                .stream()
                .filter(it -> it instanceof Arquivo)
                .count();
    }

    public int getTamanho() {
        int total = 0;
        for (ItemSistemaArquivo item : filhos) {
            total += item.getTamanho();
        }
        return total;
    }

    public void remover(Pasta subPasta) {
        filhos.remove(subPasta);
    }

    public void remover(Arquivo arquivo) {
        filhos.remove(arquivo);
    }

    public boolean temFilhoComNome(String nome) {
        return filhos.stream().anyMatch(it -> it.getNome().equals(nome));
    }

    public Pasta getSubPastaPorNome(String nome) {
        return (Pasta) filhos.stream().filter(it -> it instanceof Pasta && it.getNome().equals(nome)).findFirst().orElse(null);
    }
}

