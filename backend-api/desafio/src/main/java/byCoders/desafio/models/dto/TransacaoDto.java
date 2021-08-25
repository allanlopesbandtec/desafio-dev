package byCoders.desafio.models.dto;

import byCoders.desafio.models.Loja;
import byCoders.desafio.models.Transacao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TransacaoDto {

    private Integer id;

    private LocalDate data;

    private String valor;

    private String cpfBeneficiario;

    private LocalTime hora;

    private String donoLoja;

    private String nomeLoja;

    private String saldoLoja;

    private String descricaoTipo;

    public TransacaoDto(Transacao transacao, Loja loja) {
        this.id = transacao.getIdTransacao();
        this.data = LocalDate.of(
                Integer.parseInt(transacao.getDataTransacao().substring(0,4)),
                Integer.parseInt(transacao.getDataTransacao().substring(4,6)),
                Integer.parseInt(transacao.getDataTransacao().substring(6,8))
        );
        this.valor = String.format("%.2f",transacao.getValorTransacao());
        this.cpfBeneficiario = transacao.getCpfTransacao().toString();
        this.hora = LocalTime.of(
                Integer.parseInt(transacao.getHoraTransacao().substring(0,2)),
                Integer.parseInt(transacao.getHoraTransacao().substring(2,4)),
                Integer.parseInt(transacao.getHoraTransacao().substring(4,6))
        );
        this.donoLoja = loja.getDonoLoja();
        this.nomeLoja = loja.getNomeLoja();
        this.saldoLoja = String.format("%.2f",loja.getSaldoLoja());
        this.descricaoTipo = transacao.getDescricaoTransacao();
    }


    public String getData() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return data.format(formatters);
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
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

    public String getSaldoLoja() {
        return saldoLoja;
    }

    public void setSaldoLoja(String saldoLoja) {
        this.saldoLoja = saldoLoja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
