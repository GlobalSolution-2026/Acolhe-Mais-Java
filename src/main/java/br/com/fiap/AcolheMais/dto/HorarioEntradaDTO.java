package br.com.fiap.AcolheMais.dto;

import java.time.LocalDateTime;

public class HorarioEntradaDTO {
    private LocalDateTime dtHorario;
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
