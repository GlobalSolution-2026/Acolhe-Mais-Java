package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO de entrada do cadastro de cidadão, com as validações de Bean Validation.
 *
 * @author Nicolas Martins
 */
public class CidadaoEntradaDTO {
    @NotBlank(message = "Nome do cidadão é obrigatório")
    private String nmCidadao;

    @NotNull(message = "O CNS deve ter exatamente 15 números")
    @Pattern(regexp = "\\d{15}", message = "O CNS deve ter exatamente 15 números")
    private String nrCns;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 números")
    private String nrCpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve estar no passado")
    private LocalDate dtNascimento;

    @NotNull(message = "Sexo deve ser F ou M")
    @Pattern(regexp = "F|M", message = "Sexo deve ser F ou M")
    private String dsSexo;

    private String nrCelular;
    private String nmContatoRecado;
    private String nrContatoRecado;
    private String nrCep;

    @NotNull(message = "Tipo de acesso deve ser SENHA ou BALCAO")
    @Pattern(regexp = "SENHA|BALCAO", message = "Tipo de acesso deve ser SENHA ou BALCAO")
    private String tpAcesso;

    @Size(min = 6, message = "A senha precisa ter pelo menos 6 caracteres")
    private String senha;

    public CidadaoEntradaDTO() {
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

    // esse método devolve a senha
    public String getSenha() {
        return senha;
    }

    // esse método altera a senha
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
