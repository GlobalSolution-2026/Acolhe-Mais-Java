package br.com.fiap.AcolheMais.dto;

public class UnidadeSaidaDTO {
    private String nmUnidade, tpUnidade, dsEndereco, nrCep, nrTelefone;
    private int idUnidade;

    public UnidadeSaidaDTO(String nmUnidade, String tpUnidade, String dsEndereco, String nrCep, String nrTelefone, int idUnidade) {
        this.nmUnidade = nmUnidade;
        this.tpUnidade = tpUnidade;
        this.dsEndereco = dsEndereco;
        this.nrCep = nrCep;
        this.nrTelefone = nrTelefone;
        this.idUnidade = idUnidade;
    }

    public UnidadeSaidaDTO() {
    }

    public String getNmUnidade() {
        return nmUnidade;
    }

    public void setNmUnidade(String nmUnidade) {
        this.nmUnidade = nmUnidade;
    }

    public String getTpUnidade() {
        return tpUnidade;
    }

    public void setTpUnidade(String tpUnidade) {
        this.tpUnidade = tpUnidade;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }
}
