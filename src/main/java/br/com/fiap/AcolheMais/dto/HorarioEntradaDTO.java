package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

/**
 * DTO de entrada do horário, com data futura e duração validadas.
 *
 * @author Nicolas Martins
 */
public class HorarioEntradaDTO {
    @NotNull(message = "Data e hora são obrigatórias")
    @Future(message = "O horário deve estar no futuro")
    private LocalDateTime dtHorario;

    @Positive(message = "A duração deve ser maior que zero")
    @Max(value = 240, message = "A duração deve ser de no máximo 240 minutos")
    private int nrDuracaoMinuto;

    public HorarioEntradaDTO() {
    }

    // esse método devolve a data e hora do horário
    public LocalDateTime getDtHorario() {
        return dtHorario;
    }

    // esse método altera a data e hora do horário
    public void setDtHorario(LocalDateTime dtHorario) {
        this.dtHorario = dtHorario;
    }

    // esse método devolve a duração em minutos
    public int getNrDuracaoMinuto() {
        return nrDuracaoMinuto;
    }

    // esse método altera a duração em minutos
    public void setNrDuracaoMinuto(int nrDuracaoMinuto) {
        this.nrDuracaoMinuto = nrDuracaoMinuto;
    }
}
