package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * DTO de entrada da troca de status da consulta, com o canal de confirmação.
 *
 * @author Nicolas Martins
 */
public class StatusConsultaDTO {
    @NotNull(message = "O status é obrigatório")
    @Pattern(regexp = "AGENDADA|CONFIRMADA|LIBERADA|REALIZADA|FALTA", message = "Status inválido")
    private String dsStatus;

    @Pattern(regexp = "APP|TELEFONE|PRESENCIAL", message = "Canal inválido")
    private String dsCanalConfirmacao;

    public StatusConsultaDTO() {
    }

    // esse método devolve o status da consulta
    public String getDsStatus() {
        return dsStatus;
    }

    // esse método altera o status da consulta
    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    // esse método devolve o canal da confirmação (APP, TELEFONE ou PRESENCIAL)
    public String getDsCanalConfirmacao() {
        return dsCanalConfirmacao;
    }

    // esse método altera o canal da confirmação (APP, TELEFONE ou PRESENCIAL)
    public void setDsCanalConfirmacao(String dsCanalConfirmacao) {
        this.dsCanalConfirmacao = dsCanalConfirmacao;
    }
}
