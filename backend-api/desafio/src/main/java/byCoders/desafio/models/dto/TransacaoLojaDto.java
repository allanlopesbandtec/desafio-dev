package byCoders.desafio.models.dto;

import java.util.List;

public class TransacaoLojaDto {

    private String saldoLoja;

    private String nomeLoja;

    private List<TransacaoDto> lojasList;

    public TransacaoLojaDto(Double saldo, String nomeLoja, List<TransacaoDto> lojasList) {
        this.saldoLoja = String.format("%.2f", saldo);;
        this.nomeLoja = nomeLoja;
        this.lojasList = lojasList;
    }

    public TransacaoLojaDto() {
    }

    public String getSaldoLoja() {
        return saldoLoja;
    }

    public void setSaldoLoja(String saldoLoja) {
        this.saldoLoja = saldoLoja;
    }

    public List<TransacaoDto> getLojasList() {
        return lojasList;
    }

    public void setLojasList(List<TransacaoDto> lojasList) {
        this.lojasList = lojasList;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
