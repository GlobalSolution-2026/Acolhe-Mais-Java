package br.com.fiap.AcolheMais.dto;

import java.time.LocalDateTime;

/**
 * DTO de saída da consulta, com ids, nomes, datas, status e risco de falta para o front.
 *
 * @author Nicolas Martins
 */
public class ConsultaSaidaDTO {
    private int idConsulta, idCidadao, idHorario;
    private String nmUnidade, nmCidadao, dsStatus, dsCanalConfirmacao, dsRiscoFalta;
    private LocalDateTime dtHorario, dtAgendamento, dtConfirmacao;
    private Double vlProbFalta;
    private Integer idOrientacao;

    public ConsultaSaidaDTO() {
    }

    // esse método devolve o id da consulta
    public int getIdConsulta() {
        return idConsulta;
    }

    // esse método altera o id da consulta
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    // esse método devolve o id do cidadão
    public int getIdCidadao() {
        return idCidadao;
    }

    // esse método altera o id do cidadão
    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    // esse método devolve o id do horário
    public int getIdHorario() {
        return idHorario;
    }

    // esse método altera o id do horário
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    // esse método devolve o nome da unidade
    public String getNmUnidade() {
        return nmUnidade;
    }

    // esse método altera o nome da unidade
    public void setNmUnidade(String nmUnidade) {
        this.nmUnidade = nmUnidade;
    }

    // esse método devolve a data e hora do horário
    public LocalDateTime getDtHorario() {
        return dtHorario;
    }

    // esse método altera a data e hora do horário
    public void setDtHorario(LocalDateTime dtHorario) {
        this.dtHorario = dtHorario;
    }

    // esse método devolve o nome do cidadão
    public String getNmCidadao() {
        return nmCidadao;
    }

    // esse método altera o nome do cidadão
    public void setNmCidadao(String nmCidadao) {
        this.nmCidadao = nmCidadao;
    }

    // esse método devolve a data e hora do agendamento
    public LocalDateTime getDtAgendamento() {
        return dtAgendamento;
    }

    // esse método altera a data e hora do agendamento
    public void setDtAgendamento(LocalDateTime dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    // esse método devolve a data e hora da confirmação
    public LocalDateTime getDtConfirmacao() {
        return dtConfirmacao;
    }

    // esse método altera a data e hora da confirmação
    public void setDtConfirmacao(LocalDateTime dtConfirmacao) {
        this.dtConfirmacao = dtConfirmacao;
    }

    // esse método devolve o canal da confirmação (APP, TELEFONE ou PRESENCIAL)
    public String getDsCanalConfirmacao() {
        return dsCanalConfirmacao;
    }

    // esse método altera o canal da confirmação (APP, TELEFONE ou PRESENCIAL)
    public void setDsCanalConfirmacao(String dsCanalConfirmacao) {
        this.dsCanalConfirmacao = dsCanalConfirmacao;
    }

    // esse método devolve o status da consulta
    public String getDsStatus() {
        return dsStatus;
    }

    // esse método altera o status da consulta
    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
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
