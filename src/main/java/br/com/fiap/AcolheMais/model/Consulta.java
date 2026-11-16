package br.com.fiap.AcolheMais.model;

import java.time.LocalDateTime;

/**
 * Modelo que espelha a tabela ACM_CONSULTA do banco.
 *
 * @author Nicolas Martins
 */
public class Consulta {
    private int idConsulta, idHorario, idCidadao;
    private Integer idOrientacao;
    private LocalDateTime dtAgendamento, dtConfirmacao;
    private String dsCanalConfirmacao, dsStatus, dsRiscoFalta;
    private Double vlProbFalta;

    public Consulta() {
    }

    public Consulta(int idHorario, int idCidadao, Integer idOrientacao, LocalDateTime dtAgendamento, LocalDateTime dtConfirmacao, String dsCanalConfirmacao, String dsStatus, String dsRiscoFalta, Double vlProbFalta) {
        this.idHorario = idHorario;
        this.idCidadao = idCidadao;
        this.idOrientacao = idOrientacao;
        this.dtAgendamento = dtAgendamento;
        this.dtConfirmacao = dtConfirmacao;
        this.dsCanalConfirmacao = dsCanalConfirmacao;
        this.dsStatus = dsStatus;
        this.dsRiscoFalta = dsRiscoFalta;
        this.vlProbFalta = vlProbFalta;
    }

    public Consulta(int idConsulta, int idHorario, int idCidadao, Integer idOrientacao, LocalDateTime dtAgendamento, LocalDateTime dtConfirmacao, String dsCanalConfirmacao, String dsStatus, String dsRiscoFalta, Double vlProbFalta) {
        this.idConsulta = idConsulta;
        this.idHorario = idHorario;
        this.idCidadao = idCidadao;
        this.idOrientacao = idOrientacao;
        this.dtAgendamento = dtAgendamento;
        this.dtConfirmacao = dtConfirmacao;
        this.dsCanalConfirmacao = dsCanalConfirmacao;
        this.dsStatus = dsStatus;
        this.dsRiscoFalta = dsRiscoFalta;
        this.vlProbFalta = vlProbFalta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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

    public Integer getIdOrientacao() {
        return idOrientacao;
    }

    public void setIdOrientacao(Integer idOrientacao) {
        this.idOrientacao = idOrientacao;
    }

    public LocalDateTime getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(LocalDateTime dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public LocalDateTime getDtConfirmacao() {
        return dtConfirmacao;
    }

    public void setDtConfirmacao(LocalDateTime dtConfirmacao) {
        this.dtConfirmacao = dtConfirmacao;
    }

    public String getDsCanalConfirmacao() {
        return dsCanalConfirmacao;
    }

    public void setDsCanalConfirmacao(String dsCanalConfirmacao) {
        this.dsCanalConfirmacao = dsCanalConfirmacao;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public String getDsRiscoFalta() {
        return dsRiscoFalta;
    }

    public void setDsRiscoFalta(String dsRiscoFalta) {
        this.dsRiscoFalta = dsRiscoFalta;
    }

    public Double getVlProbFalta() {
        return vlProbFalta;
    }

    public void setVlProbFalta(Double vlProbFalta) {
        this.vlProbFalta = vlProbFalta;
    }
}
