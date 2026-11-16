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

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getNmUnidade() {
        return nmUnidade;
    }

    public void setNmUnidade(String nmUnidade) {
        this.nmUnidade = nmUnidade;
    }

    public LocalDateTime getDtHorario() {
        return dtHorario;
    }

    public void setDtHorario(LocalDateTime dtHorario) {
        this.dtHorario = dtHorario;
    }

    public String getNmCidadao() {
        return nmCidadao;
    }

    public void setNmCidadao(String nmCidadao) {
        this.nmCidadao = nmCidadao;
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
