package byCoders.desafio.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoTransacao {

    @Id
    private Integer idTipoTransacao;

    private String descricao;

    private String natureza;

    private String sinal;

    public TipoTransacao(Integer idTipoTransacao, String descricao, String natureza, String sinal) {
        this.idTipoTransacao = idTipoTransacao;
        this.descricao = descricao;
        this.natureza = natureza;
        this.sinal = sinal;
    }

    public TipoTransacao() {
    }

    public Integer getIdTipoTransacao() {
        return idTipoTransacao;
    }

    public void setIdTipoTransacao(Integer idTipoTransacao) {
        this.idTipoTransacao = idTipoTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }
}
