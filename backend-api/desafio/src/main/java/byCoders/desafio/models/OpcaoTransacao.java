package byCoders.desafio.models;

public enum OpcaoTransacao {

    DEBITO("DEBITO", "Entrada"),
    BOLETO("BOLETO", "Saída"),
    FINANCIAMENTO("FINANCIAMENTO", "Saída"),
    CREDITO("CRÉDITO", "Entrada"),
    EMPRESTIMO("RECEBIMENTO Emprestimo", "Entrada"),
    VENDAS("VENDAS", "Entrada"),
    TED("RECEBIMENTO TED", "Entrada"),
    DOC("RECEBIMENTO DOC", "Entrada"),
    ALUGUEL("ALUGEL", "Saída");

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
