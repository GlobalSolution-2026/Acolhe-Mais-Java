package br.com.fiap.AcolheMais.model;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta, idHorario, idCidadao, idOrientacao;
    private LocalDateTime dtAgendamento, dtConfirmacao;
    private String dsStatus, dsRiscoFalta;
    private double vlProbFalta;

    public Consulta() {
    }

    public Consulta(int idHorario, int idCidadao, int idOrientacao, LocalDateTime dtAgendamento, LocalDateTime dtConfirmacao, String dsStatus, String dsRiscoFalta, double vlProbFalta) {
        this.idHorario = idHorario;
        this.idCidadao = idCidadao;
        this.idOrientacao = idOrientacao;
        this.dtAgendamento = dtAgendamento;
        this.dtConfirmacao = dtConfirmacao;
        this.dsStatus = dsStatus;
        this.dsRiscoFalta = dsRiscoFalta;
        this.vlProbFalta = vlProbFalta;
    }

    public Consulta(int idConsulta, int idHorario, int idCidadao, int idOrientacao, LocalDateTime dtAgendamento, LocalDateTime dtConfirmacao, String dsStatus, String dsRiscoFalta, double vlProbFalta) {
        this.idConsulta = idConsulta;
        this.idHorario = idHorario;
        this.idCidadao = idCidadao;
        this.idOrientacao = idOrientacao;
        this.dtAgendamento = dtAgendamento;
        this.dtConfirmacao = dtConfirmacao;
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

    public int getIdOrientacao() {
        return idOrientacao;
    }

    public void setIdOrientacao(int idOrientacao) {
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

    public double getVlProbFalta() {
        return vlProbFalta;
    }

    public void setVlProbFalta(double vlProbFalta) {
        this.vlProbFalta = vlProbFalta;
    }
}
