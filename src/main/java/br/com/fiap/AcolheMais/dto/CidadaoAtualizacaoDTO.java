package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.Pattern;

public class CidadaoAtualizacaoDTO {
    @Pattern(regexp = "\\d{10,11}", message = "Informe o celular com DDD (só números)")
    private String nrCelular;

    private String nmContatoRecado;

    @Pattern(regexp = "\\d{10,11}", message = "Informe o telefone de recado com DDD")
    private String nrContatoRecado;

    @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 números")
    private String nrCep;

    public CidadaoAtualizacaoDTO() {
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public String getNmContatoRecado() {
        return nmContatoRecado;
    }

    public void setNmContatoRecado(String nmContatoRecado) {
        this.nmContatoRecado = nmContatoRecado;
    }

    public String getNrContatoRecado() {
        return nrContatoRecado;
    }

    public void setNrContatoRecado(String nrContatoRecado) {
        this.nrContatoRecado = nrContatoRecado;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }
}
