package br.com.fiap.AcolheMais.dto;

import java.time.LocalDate;

public class CidadaoEntradaDTO {
    private String nmCidadao, nrCns, nrCpf, dsSexo, nrCelular, nmContatoRecado, nrContatoRecado, nrCep, tpAcesso, senha;
    private LocalDate dtNascimento;

    public CidadaoEntradaDTO() {
    }

    public String getNmCidadao() {
        return nmCidadao;
    }

    public void setNmCidadao(String nmCidadao) {
        this.nmCidadao = nmCidadao;
    }

    public String getNrCns() {
        return nrCns;
    }

    public void setNrCns(String nrCns) {
        this.nrCns = nrCns;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getDsSexo() {
        return dsSexo;
    }

    public void setDsSexo(String dsSexo) {
        this.dsSexo = dsSexo;
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

    public String getTpAcesso() {
        return tpAcesso;
    }

    public void setTpAcesso(String tpAcesso) {
        this.tpAcesso = tpAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
