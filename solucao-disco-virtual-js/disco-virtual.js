class Pasta {
    constructor(nome, pastaPai) {
        this.nome = nome
        this.pastaPai = pastaPai
        this.subPastas = []
        this.arquivos = []
    }

    get Nome() {
        return this.nome
    }

    set Nome(nome) {
        this.nome = nome
    }

    get PastaPai() {
        return this.pastaPai
    }

    get CaminhoDesdeRaiz() {
        const caminho = []
        let pastaAtual = this
        while(pastaAtual) {
            caminho.unshift(pastaAtual)
            pastaAtual = pastaAtual.PastaPai
        }
        return caminho
    }

    eRaiz() {
        return this.pastaPai === undefined
    }

    get SubPastas() {
        return [...this.subPastas]
    }

    get Arquivos() {
        return [...this.arquivos]
    }

    addPasta(subPasta) {
        if(this.temFilhoComNome(subPasta.Nome)) {
            throw new Error('Já existe um outro item com este nome')
        }

        if(subPasta.temPai()) {
            throw new Error('A subpasta informada já está dentro de outra pasta. Use mover')
        }
        this.subPastas.push(subPasta)
    }

    novaSubPasta(nome) {
        if(this.temFilhoComNome(nome)) {
            throw new Error('Já existe um outro item com este nome')
        }

        const subPasta = new Pasta(nome, this)
        this.subPastas.push(subPasta)
        return subPasta
    }

    addArquivo(arquivo) {
        if(this.temFilhoComNome(arquivo.Nome)) {
            throw new Error('Já existe um outro item com este nome')
        }
        this.arquivos.push(arquivo)
    }

    novoArquivo(nome, tamanho) {
        if(this.temFilhoComNome(nome)) {
            throw new Error('Já existe um outro item com este nome')
        }
        const arquivo = new Arquivo(nome, tamanho)
        this.arquivos.push(arquivo)
        return arquivo
    }

    quantasSubPastas() {
        return this.subPastas.length
    }

    quantosArquivos() {
        return this.arquivos.length
    }

    get Tamanho() {
        let total = 0
        for(const arquivo of this.arquivos) {
            total += arquivo.Tamanho
        }
        for(const subPasta of this.subPastas) {
            total += subPasta.Tamanho
        }
        return total
    }

    removerSubPasta(subPasta) {
        this.subPastas = this.subPastas
            .filter(it => it !== subPasta)
    }

    removerArquivo(arquivo) {
        this.arquivos = this.arquivos
            .filter(it => it !== arquivo)
    }

    temFilhoComNome(nome) {
        return this.subPastas
                 .some(it => it.Nome === nome)
                 ||
               this.arquivos
                 .some(it => it.Nome === nome)
    }

    getSubPastaPorNome(nome) {
        const subPastas = this.subPastas.filter(it => it.Nome == nome)
        if(subPastas.length > 0) {
            return subPastas[0]
        }
    }

}

class Arquivo {
    constructor(nome, tamanho) {
        this.nome = nome
        this.tamanho = tamanho
    }

    get Nome() {
        return this.nome
    }

    set Nome(nome) {
        this.nome = nome
    }

    get Tamanho() {
        return this.tamanho || 0
    }

    set Tamanho(tamanho) {
        this.tamanho = tamanho
    }
}