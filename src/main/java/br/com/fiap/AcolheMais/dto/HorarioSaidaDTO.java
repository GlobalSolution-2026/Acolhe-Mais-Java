package br.com.fiap.AcolheMais.dto;

import java.time.LocalDateTime;

/**
 * DTO de saída do horário, com a flag que indica se está ocupado.
 *
 * @author Nicolas Martins
 */
public class HorarioSaidaDTO {
    private int idHorario, idUnidade, nrDuracaoMinuto;
    private LocalDateTime dtHorario;
    private boolean flOcupado;

    public HorarioSaidaDTO() {
    }

    public HorarioSaidaDTO(int idHorario, int idUnidade, LocalDateTime dtHorario, int nrDuracaoMinuto) {
        this.idHorario = idHorario;
        this.idUnidade = idUnidade;
        this.dtHorario = dtHorario;
        this.nrDuracaoMinuto = nrDuracaoMinuto;
    }

    // esse método devolve o id do horário
    public int getIdHorario() {
        return idHorario;
    }

    // esse método altera o id do horário
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    // esse método devolve o id da unidade
    public int getIdUnidade() {
        return idUnidade;
    }

    // esse método altera o id da unidade
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
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

    // esse método devolve se o horário está ocupado
    public boolean isFlOcupado() {
        return flOcupado;
    }

    // esse método altera se o horário está ocupado
    public void setFlOcupado(boolean flOcupado) {
        this.flOcupado = flOcupado;
    }
}
