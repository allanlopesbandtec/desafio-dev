package byCoders.desafio.models;

import javax.persistence.*;


@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransacao;

    private String dataTransacao;

    private Double valorTransacao;

    private Long cpfTransacao;

    private String cartaoTransacao;

    private String horaTransacao;

    private String natureza;

    private String descricaoTransacao;

    @ManyToOne
    @JoinColumn(name = "fk_loja")
    private Loja loja;

    public Transacao(Integer idTransacao, String dataTransacao, Double valorTransacao, Long cpfTransacao, String cartaoTransacao, String horaTransacao, String natureza, String descricaoTransacao, Loja loja) {
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.cpfTransacao = cpfTransacao;
        this.cartaoTransacao = cartaoTransacao;
        this.horaTransacao = horaTransacao;
        this.natureza = natureza;
        this.descricaoTransacao = descricaoTransacao;
        this.loja = loja;
    }

    public Transacao() {
    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(Double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public Long getCpfTransacao() {
        return cpfTransacao;
    }

    public void setCpfTransacao(Long cpfTransacao) {
        this.cpfTransacao = cpfTransacao;
    }

    public String getCartaoTransacao() {
        return cartaoTransacao;
    }

    public void setCartaoTransacao(String cartaoTransacao) {
        this.cartaoTransacao = cartaoTransacao;
    }

    public String getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(String horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }
}
