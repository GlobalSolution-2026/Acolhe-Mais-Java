package br.com.fiap.AcolheMais.model;

import java.time.LocalDateTime;

public class Horario {
    private int idHorario, idUnidade, nrDuracaoMinuto;
    private LocalDateTime dtHorario;

    public Horario() {
    }

    public Horario(int idUnidade, int nrDuracaoMinuto, LocalDateTime dtHorario) {
        this.idUnidade = idUnidade;
        this.nrDuracaoMinuto = nrDuracaoMinuto;
        this.dtHorario = dtHorario;
    }

    public Horario(int idHorario, int idUnidade, int nrDuracaoMinuto, LocalDateTime dtHorario) {
        this.idHorario = idHorario;
        this.idUnidade = idUnidade;
        this.nrDuracaoMinuto = nrDuracaoMinuto;
        this.dtHorario = dtHorario;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public int getNrDuracaoMinuto() {
        return nrDuracaoMinuto;
    }

    public void setNrDuracaoMinuto(int nrDuracaoMinuto) {
        this.nrDuracaoMinuto = nrDuracaoMinuto;
    }

    public LocalDateTime getDtHorario() {
        return dtHorario;
    }

    public void setDtHorario(LocalDateTime dtHorario) {
        this.dtHorario = dtHorario;
    }
}
