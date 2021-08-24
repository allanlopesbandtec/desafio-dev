package byCoders.desafio.models.dto;

import byCoders.desafio.models.TipoTransacao;
import byCoders.desafio.models.Transacao;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransacaoDto {

    private Integer tipo;

    private LocalDate data;

    private Double valor;

    private String cpfBeneficiario;

    private String cartao;

    private LocalTime hora;

    private String donoLoja;

    private String nomeLoja;

    private String descricaoTipo;

    public TransacaoDto(Transacao transacao, TipoTransacao tipoTransacao) {
        this.tipo = tipoTransacao.getIdTipoTransacao();
        this.data = LocalDate.of(
                Integer.parseInt(transacao.getDataTransacao().substring(0,4)),
                Integer.parseInt(transacao.getDataTransacao().substring(4,6)),
                Integer.parseInt(transacao.getDataTransacao().substring(6,8))
        );
        this.valor = transacao.getValorTransacao();
        this.cpfBeneficiario = transacao.getCpfTransacao().toString();
        this.cartao = transacao.getCartaoTransacao();
        this.hora = LocalTime.of(
                Integer.parseInt(transacao.getHoraTransacao().substring(0,2)),
                Integer.parseInt(transacao.getHoraTransacao().substring(2,4)),
                Integer.parseInt(transacao.getHoraTransacao().substring(4,6))
        );
        this.donoLoja = transacao.getDonoLoja();
        this.nomeLoja = transacao.getNomeLoja();
        this.descricaoTipo = tipoTransacao.getDescricao();
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDonoLoja() {
        return donoLoja;
    }

    public void setDonoLoja(String donoLoja) {
        this.donoLoja = donoLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }
}
