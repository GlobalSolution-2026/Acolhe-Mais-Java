package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "Informe o Cartão SUS")
    private String nrCns;

    @NotBlank(message = "Informe a senha")
    private String senha;

    public LoginDTO() {
    }

    public String getNrCns() {
        return nrCns;
    }

    public void setNrCns(String nrCns) {
        this.nrCns = nrCns;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
