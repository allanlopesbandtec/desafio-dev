package byCoders.desafio.models;

public enum OpcaoTransacao {

    DEBITO("Debito", "Entrada"),
    BOLETO("Boleto", "Saída"),
    FINANCIAMENTO("Financiamento", "Saída"),
    CREDITO("Crédito", "Entrada"),
    EMPRESTIMO("Recebimento Emprestimo", "Entrada"),
    VENDAS("Vendas", "Entrada"),
    TED("Recebimento TED", "Entrada"),
    DOC("Recebimento DOC", "Entrada"),
    ALUGUEL("Aluguel", "Saída");

    private String descricaoTransacao;

    private String natureza;

    OpcaoTransacao(String descricaoTransacao, String natureza){
       this.descricaoTransacao = descricaoTransacao;
       this.natureza = natureza;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }
}
