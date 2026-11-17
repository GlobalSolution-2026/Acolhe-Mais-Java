package br.com.fiap.AcolheMais.dto;

/**
 * DTO de saída da unidade de saúde, devolvido pela API com o id.
 *
 * @author Nicolas Martins
 */
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

    // esse método devolve o nome da unidade
    public String getNmUnidade() {
        return nmUnidade;
    }

    // esse método altera o nome da unidade
    public void setNmUnidade(String nmUnidade) {
        this.nmUnidade = nmUnidade;
    }

    // esse método devolve o tipo da unidade (UBS ou UPA)
    public String getTpUnidade() {
        return tpUnidade;
    }

    // esse método altera o tipo da unidade (UBS ou UPA)
    public void setTpUnidade(String tpUnidade) {
        this.tpUnidade = tpUnidade;
    }

    // esse método devolve o endereço
    public String getDsEndereco() {
        return dsEndereco;
    }

    // esse método altera o endereço
    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    // esse método devolve o CEP
    public String getNrCep() {
        return nrCep;
    }

    // esse método altera o CEP
    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    // esse método devolve o telefone
    public String getNrTelefone() {
        return nrTelefone;
    }

    // esse método altera o telefone
    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    // esse método devolve o id da unidade
    public int getIdUnidade() {
        return idUnidade;
    }

    // esse método altera o id da unidade
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }
}
