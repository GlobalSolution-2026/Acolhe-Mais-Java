package br.com.fiap.AcolheMais.dto;

import java.time.LocalDate;

/**
 * DTO de saída do cidadão, devolvido pela API sem a senha.
 *
 * @author Nicolas Martins
 */
public class CidadaoSaidaDTO {
    private int idCidadao;
    private String nmCidadao, nrCns, nrCpf, dsSexo, nrCelular, nmContatoRecado, nrContatoRecado, nrCep, tpAcesso;
    private LocalDate dtNascimento;

    public CidadaoSaidaDTO() {
    }

    public CidadaoSaidaDTO(int idCidadao, String nmCidadao, String nrCns, String nrCpf, LocalDate dtNascimento, String dsSexo, String nrCelular, String nmContatoRecado, String nrContatoRecado, String nrCep, String tpAcesso) {
        this.idCidadao = idCidadao;
        this.nmCidadao = nmCidadao;
        this.nrCns = nrCns;
        this.nrCpf = nrCpf;
        this.dtNascimento = dtNascimento;
        this.dsSexo = dsSexo;
        this.nrCelular = nrCelular;
        this.nmContatoRecado = nmContatoRecado;
        this.nrContatoRecado = nrContatoRecado;
        this.nrCep = nrCep;
        this.tpAcesso = tpAcesso;
    }

    public int getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
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
}
