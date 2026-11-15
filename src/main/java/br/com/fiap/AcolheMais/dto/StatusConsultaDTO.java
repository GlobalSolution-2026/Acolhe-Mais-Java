package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StatusConsultaDTO {
    @NotNull(message = "O status é obrigatório")
    @Pattern(regexp = "AGENDADA|CONFIRMADA|LIBERADA|REALIZADA|FALTA", message = "Status inválido")
    private String dsStatus;

    @Pattern(regexp = "APP|TELEFONE|PRESENCIAL", message = "Canal inválido")
    private String dsCanalConfirmacao;

    public StatusConsultaDTO() {
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public String getDsCanalConfirmacao() {
        return dsCanalConfirmacao;
    }

    public void setDsCanalConfirmacao(String dsCanalConfirmacao) {
        this.dsCanalConfirmacao = dsCanalConfirmacao;
    }
}
