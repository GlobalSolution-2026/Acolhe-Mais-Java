package br.com.fiap.AcolheMais.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * DTO de entrada para agendar ou alterar uma consulta (horário, cidadão e risco de falta).
 *
 * @author Nicolas Martins
 */
public class ConsultaEntradaDTO {
    @Positive(message = "O horário é obrigatório")
    private int idHorario;

    @Positive(message = "O cidadão é obrigatório")
    private int idCidadao;

    @DecimalMin(value = "0.0", message = "A probabilidade de falta deve estar entre 0 e 1")
    @DecimalMax(value = "1.0", message = "A probabilidade de falta deve estar entre 0 e 1")
    private Double vlProbFalta;

    @Pattern(regexp = "ALTO|BAIXO", message = "O risco de falta deve ser ALTO ou BAIXO")
    private String dsRiscoFalta;

    @Positive(message = "A orientação informada é inválida")
    private Integer idOrientacao;

    public ConsultaEntradaDTO() {
    }

    // esse método devolve o id do horário
    public int getIdHorario() {
        return idHorario;
    }

    // esse método altera o id do horário
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    // esse método devolve o id do cidadão
    public int getIdCidadao() {
        return idCidadao;
    }

    // esse método altera o id do cidadão
    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    // esse método devolve a probabilidade de falta (de 0 a 1)
    public Double getVlProbFalta() {
        return vlProbFalta;
    }

    // esse método altera a probabilidade de falta (de 0 a 1)
    public void setVlProbFalta(Double vlProbFalta) {
        this.vlProbFalta = vlProbFalta;
    }

    // esse método devolve o risco de falta (ALTO ou BAIXO)
    public String getDsRiscoFalta() {
        return dsRiscoFalta;
    }

    // esse método altera o risco de falta (ALTO ou BAIXO)
    public void setDsRiscoFalta(String dsRiscoFalta) {
        this.dsRiscoFalta = dsRiscoFalta;
    }

    // esse método devolve o id da orientação
    public Integer getIdOrientacao() {
        return idOrientacao;
    }

    // esse método altera o id da orientação
    public void setIdOrientacao(Integer idOrientacao) {
        this.idOrientacao = idOrientacao;
    }
}
