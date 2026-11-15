package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UnidadeEntradaDTO {
    @NotBlank(message = "Nome da unidade é obrigatório")
    private String nmUnidade;

    @NotNull(message = "Tipo deve ser UBS ou UPA")
    @Pattern(regexp = "UBS|UPA", message = "Tipo deve ser UBS ou UPA")
    private String tpUnidade;

    @NotBlank(message = "Endereço é obrigatório")
    private String dsEndereco;

    private String nrCep;
    private String nrTelefone;

    public UnidadeEntradaDTO() {
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
