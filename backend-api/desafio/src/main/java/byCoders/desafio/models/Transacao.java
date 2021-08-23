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

    @ManyToOne
    private TipoTransacao tipoTransacao;

    private String nomeLoja;

    private String donoLoja;

    public Transacao(Integer idTransacao, String dataTransacao, Double valorTransacao, Long cpfTransacao, String cartaoTransacao, String horaTransacao, TipoTransacao tipoTransacao, String nomeLoja, String donoLoja) {
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.cpfTransacao = cpfTransacao;
        this.cartaoTransacao = cartaoTransacao;
        this.horaTransacao = horaTransacao;
        this.tipoTransacao = tipoTransacao;
        this.nomeLoja = nomeLoja;
        this.donoLoja = donoLoja;
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

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getDonoLoja() {
        return donoLoja;
    }

    public void setDonoLoja(String donoLoja) {
        this.donoLoja = donoLoja;
    }
}
