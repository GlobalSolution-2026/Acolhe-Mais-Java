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
}
