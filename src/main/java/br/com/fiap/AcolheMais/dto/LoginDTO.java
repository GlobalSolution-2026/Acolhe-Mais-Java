package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO de entrada do login do cidadão com Cartão SUS e senha.
 *
 * @author Nicolas Martins
 */
public class LoginDTO {
    @NotBlank(message = "Informe o Cartão SUS")
    private String nrCns;

    @NotBlank(message = "Informe a senha")
    private String senha;

    public LoginDTO() {
    }

    // esse método devolve o número do Cartão SUS (CNS)
    public String getNrCns() {
        return nrCns;
    }

    // esse método altera o número do Cartão SUS (CNS)
    public void setNrCns(String nrCns) {
        this.nrCns = nrCns;
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
