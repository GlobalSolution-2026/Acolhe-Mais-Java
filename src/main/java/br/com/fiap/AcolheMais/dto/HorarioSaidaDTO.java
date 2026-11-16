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

    public boolean isFlOcupado() {
        return flOcupado;
    }

    public void setFlOcupado(boolean flOcupado) {
        this.flOcupado = flOcupado;
    }
}
