package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.Pattern;

/**
 * DTO de entrada da edição do cidadão, aceita só contato e CEP.
 *
 * @author Nicolas Martins
 */
public class CidadaoAtualizacaoDTO {
    @Pattern(regexp = "(\\d{10,11})?", message = "Informe o celular com DDD (só números)")
    private String nrCelular;

    private String nmContatoRecado;

    @Pattern(regexp = "(\\d{10,11})?", message = "Informe o telefone de recado com DDD")
    private String nrContatoRecado;

    @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 números")
    private String nrCep;

    public CidadaoAtualizacaoDTO() {
    }

    // esse método devolve o celular
    public String getNrCelular() {
        return nrCelular;
    }

    // esse método altera o celular
    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    // esse método devolve o nome do contato de recado
    public String getNmContatoRecado() {
        return nmContatoRecado;
    }

    // esse método altera o nome do contato de recado
    public void setNmContatoRecado(String nmContatoRecado) {
        this.nmContatoRecado = nmContatoRecado;
    }

    // esse método devolve o telefone do contato de recado
    public String getNrContatoRecado() {
        return nrContatoRecado;
    }

    // esse método altera o telefone do contato de recado
    public void setNrContatoRecado(String nrContatoRecado) {
        this.nrContatoRecado = nrContatoRecado;
    }

    // esse método devolve o CEP
    public String getNrCep() {
        return nrCep;
    }

    // esse método altera o CEP
    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }
}
