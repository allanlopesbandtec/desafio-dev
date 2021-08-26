package byCoders.desafio.models.dto;

import java.util.List;

public class TransacaoLojaDto {

    private String saldoLoja;

    private String nomeLoja;

    private List<TransacaoDto> transacaoDtos;

    public TransacaoLojaDto(Double saldo, String nomeLoja, List<TransacaoDto> lojasList) {
        this.saldoLoja = String.format("%.2f", saldo);;
        this.nomeLoja = nomeLoja;
        this.transacaoDtos = lojasList;
    }

    public TransacaoLojaDto() {
    }

    public String getSaldoLoja() {
        return saldoLoja;
    }

    public void setSaldoLoja(String saldoLoja) {
        this.saldoLoja = saldoLoja;
    }

    public List<TransacaoDto> getTransacaoDtos() {
        return transacaoDtos;
    }

    public void setTransacaoDtos(List<TransacaoDto> transacaoDtos) {
        this.transacaoDtos = transacaoDtos;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
