package byCoders.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoja;

    private String donoLoja;

    private String nomeLoja;

    private Double saldoLoja;

    public Loja(Integer idLoja, String donoLoja, String nomeLoja) {
        this.idLoja = idLoja;
        this.donoLoja = donoLoja;
        this.nomeLoja = nomeLoja;
    }

    public Loja() {
    }

    public Integer getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
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

    public Double getSaldoLoja() {
        return saldoLoja;
    }

    public void setSaldoLoja(Double saldoLoja) {
        this.saldoLoja = saldoLoja;
    }
}
