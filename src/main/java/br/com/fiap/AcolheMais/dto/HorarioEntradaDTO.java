package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class HorarioEntradaDTO {
    @NotNull(message = "Data e hora são obrigatórias")
    @Future(message = "O horário deve estar no futuro")
    private LocalDateTime dtHorario;

    @Positive(message = "A duração deve ser maior que zero")
    @Max(value = 240, message = "A duração deve ser de no máximo 240 minutos")
    private int nrDuracaoMinuto;

    public HorarioEntradaDTO() {
    }

    public LocalDateTime getDtHorario() {
        return dtHorario;
    }

    public void setDtHorario(LocalDateTime dtHorario) {
        this.dtHorario = dtHorario;
    }

    public int getNrDuracaoMinuto() {
        return nrDuracaoMinuto;
    }

    public void setNrDuracaoMinuto(int nrDuracaoMinuto) {
        this.nrDuracaoMinuto = nrDuracaoMinuto;
    }
}
