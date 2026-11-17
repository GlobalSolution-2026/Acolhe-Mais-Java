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

    // esse método devolve o id do cidadão
    public int getIdCidadao() {
        return idCidadao;
    }

    // esse método altera o id do cidadão
    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    // esse método devolve o nome do cidadão
    public String getNmCidadao() {
        return nmCidadao;
    }

    // esse método altera o nome do cidadão
    public void setNmCidadao(String nmCidadao) {
        this.nmCidadao = nmCidadao;
    }

    // esse método devolve o número do Cartão SUS (CNS)
    public String getNrCns() {
        return nrCns;
    }

    // esse método altera o número do Cartão SUS (CNS)
    public void setNrCns(String nrCns) {
        this.nrCns = nrCns;
    }

    // esse método devolve o CPF
    public String getNrCpf() {
        return nrCpf;
    }

    // esse método altera o CPF
    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    // esse método devolve a data de nascimento
    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    // esse método altera a data de nascimento
    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    // esse método devolve o sexo
    public String getDsSexo() {
        return dsSexo;
    }

    // esse método altera o sexo
    public void setDsSexo(String dsSexo) {
        this.dsSexo = dsSexo;
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

    // esse método devolve o tipo de acesso (SENHA ou BALCAO)
    public String getTpAcesso() {
        return tpAcesso;
    }

    // esse método altera o tipo de acesso (SENHA ou BALCAO)
    public void setTpAcesso(String tpAcesso) {
        this.tpAcesso = tpAcesso;
    }
}
