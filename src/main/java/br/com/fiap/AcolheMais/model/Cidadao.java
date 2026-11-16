package br.com.fiap.AcolheMais.model;

import java.time.LocalDate;

/**
 * Modelo que espelha a tabela ACM_CIDADAO do banco.
 *
 * @author Nicolas Martins
 */
public class Cidadao {
    private int idCidadao;
    private String nmCidadao, nrCns, nrCpf, dsSexo, nrCelular, nmContatoRecado, nrContatoRecado, nrCep, tpAcesso, dsSenhaHash;
    private LocalDate dtNascimento;

    public Cidadao() {
    }

    public Cidadao(String nmCidadao, String nrCns, String nrCpf, String dsSexo, String nrCelular, String nmContatoRecado, String nrContatoRecado, String nrCep, String tpAcesso, String dsSenhaHash, LocalDate dtNascimento) {
        this.nmCidadao = nmCidadao;
        this.nrCns = nrCns;
        this.nrCpf = nrCpf;
        this.dsSexo = dsSexo;
        this.nrCelular = nrCelular;
        this.nmContatoRecado = nmContatoRecado;
        this.nrContatoRecado = nrContatoRecado;
        this.nrCep = nrCep;
        this.tpAcesso = tpAcesso;
        this.dsSenhaHash = dsSenhaHash;
        this.dtNascimento = dtNascimento;
    }

    public Cidadao(int idCidadao, String nmCidadao, String nrCns, String nrCpf, String dsSexo, String nrCelular, String nmContatoRecado, String nrContatoRecado, String nrCep, String tpAcesso, String dsSenhaHash, LocalDate dtNascimento) {
        this.idCidadao = idCidadao;
        this.nmCidadao = nmCidadao;
        this.nrCns = nrCns;
        this.nrCpf = nrCpf;
        this.dsSexo = dsSexo;
        this.nrCelular = nrCelular;
        this.nmContatoRecado = nmContatoRecado;
        this.nrContatoRecado = nrContatoRecado;
        this.nrCep = nrCep;
        this.tpAcesso = tpAcesso;
        this.dsSenhaHash = dsSenhaHash;
        this.dtNascimento = dtNascimento;
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

    public String getDsSenhaHash() {
        return dsSenhaHash;
    }

    public void setDsSenhaHash(String dsSenhaHash) {
        this.dsSenhaHash = dsSenhaHash;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
