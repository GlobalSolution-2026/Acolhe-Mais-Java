package br.com.fiap.AcolheMais.model;

public class Unidade {
    private static final String REGEX_CEP = "\\d{8}";
    private static final String REGEX_TELEFONE = "\\d{10,11}";

    private int idUnidade;
    private String nmUnidade, tpUnidade, dsEndereco, nrCep, nrTelefone;

    public Unidade() {
    }

    public Unidade(int idUnidade, String nmUnidade, String tpUnidade, String dsEndereco, String nrCep, String nrTelefone) {
        this.idUnidade = idUnidade;
        this.nmUnidade = nmUnidade;
        this.tpUnidade = tpUnidade;
        this.dsEndereco = dsEndereco;
        this.nrCep = nrCep;
        this.nrTelefone = nrTelefone;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
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
}
