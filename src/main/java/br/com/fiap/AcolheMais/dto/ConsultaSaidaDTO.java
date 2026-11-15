package br.com.fiap.AcolheMais.dto;

import java.time.LocalDateTime;

public class ConsultaSaidaDTO {
    private int idConsulta;
    private String nmUnidade, nmCidadao, dsStatus;
    private LocalDateTime dtHorario;

    public ConsultaSaidaDTO() {
    }

    public ConsultaSaidaDTO(int idConsulta, String nmUnidade, LocalDateTime dtHorario, String nmCidadao, String dsStatus) {
        this.idConsulta = idConsulta;
        this.nmUnidade = nmUnidade;
        this.dtHorario = dtHorario;
        this.nmCidadao = nmCidadao;
        this.dsStatus = dsStatus;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }
}
