package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * DTO de entrada da unidade de saúde, com tipo UBS ou UPA validado.
 *
 * @author Nicolas Martins
 */
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
}
