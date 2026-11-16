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

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    public Double getVlProbFalta() {
        return vlProbFalta;
    }

    public void setVlProbFalta(Double vlProbFalta) {
        this.vlProbFalta = vlProbFalta;
    }

    public String getDsRiscoFalta() {
        return dsRiscoFalta;
    }

    public void setDsRiscoFalta(String dsRiscoFalta) {
        this.dsRiscoFalta = dsRiscoFalta;
    }

    public Integer getIdOrientacao() {
        return idOrientacao;
    }

    public void setIdOrientacao(Integer idOrientacao) {
        this.idOrientacao = idOrientacao;
    }
}
