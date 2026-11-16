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
