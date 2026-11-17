package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.ConsultaEntradaDTO;
import br.com.fiap.AcolheMais.dto.ConsultaSaidaDTO;
import br.com.fiap.AcolheMais.dto.StatusConsultaDTO;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.HorarioIndisponivelException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.model.Cidadao;
import br.com.fiap.AcolheMais.model.Consulta;
import br.com.fiap.AcolheMais.model.Horario;
import br.com.fiap.AcolheMais.model.Unidade;
import br.com.fiap.AcolheMais.repository.CidadaoRepository;
import br.com.fiap.AcolheMais.repository.ConsultaRepository;
import br.com.fiap.AcolheMais.repository.HorarioRepository;
import br.com.fiap.AcolheMais.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service da consulta: regra do horário ocupado, mudança de status e CRUD.
 *
 * @author Nicolas Martins
 */
@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private HorarioRepository horarioRepository;
    private UnidadeRepository unidadeRepository;
    private CidadaoRepository cidadaoRepository;

    public ConsultaService(ConsultaRepository consultaRepository, HorarioRepository horarioRepository, UnidadeRepository unidadeRepository, CidadaoRepository cidadaoRepository) {
        this.consultaRepository = consultaRepository;
        this.horarioRepository = horarioRepository;
        this.unidadeRepository = unidadeRepository;
        this.cidadaoRepository = cidadaoRepository;
    }

    // esse método monta o DTO de saída juntando os dados do horário, da unidade e do cidadão
    private ConsultaSaidaDTO paraSaida(Consulta consulta){
        Horario horario = horarioRepository.buscarPorId(consulta.getIdHorario());
        Unidade unidade = unidadeRepository.buscarPorId(horario.getIdUnidade());
        Cidadao cidadao = cidadaoRepository.buscarPorId(consulta.getIdCidadao());
        ConsultaSaidaDTO saida = new ConsultaSaidaDTO();
        saida.setIdConsulta(consulta.getIdConsulta());
        saida.setIdCidadao(consulta.getIdCidadao());
        saida.setIdHorario(consulta.getIdHorario());
        saida.setNmUnidade(unidade.getNmUnidade());
        saida.setDtHorario(horario.getDtHorario());
        saida.setNmCidadao(cidadao.getNmCidadao());
        saida.setDtAgendamento(consulta.getDtAgendamento());
        saida.setDtConfirmacao(consulta.getDtConfirmacao());
        saida.setDsCanalConfirmacao(consulta.getDsCanalConfirmacao());
        saida.setDsStatus(consulta.getDsStatus());
        saida.setVlProbFalta(consulta.getVlProbFalta());
        saida.setDsRiscoFalta(consulta.getDsRiscoFalta());
        saida.setIdOrientacao(consulta.getIdOrientacao());
        return saida;
    }

    // esse método confere se o horário e o cidadão existem e lança 404 se algum não existir
    private void conferirHorarioECidadao(ConsultaEntradaDTO dto){
        if (horarioRepository.buscarPorId(dto.getIdHorario()) == null) {
            throw new RecursoNaoEncontradoException("Horário não encontrado");
        }
        if (cidadaoRepository.buscarPorId(dto.getIdCidadao()) == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
    }

    // esse método diz se o status é AGENDADA ou CONFIRMADA, que são os que ocupam o horário
    private boolean statusAtivo(String status){
        return "AGENDADA".equals(status) || "CONFIRMADA".equals(status);
    }

    // esse método devolve todas as consultas
    public List<ConsultaSaidaDTO> listar(){
        List<ConsultaSaidaDTO> lista = new ArrayList<>();
        for (Consulta consulta : consultaRepository.listar()) {
            lista.add(paraSaida(consulta));
        }
        return lista;
    }

    // esse método busca a consulta pelo id e lança 404 se não existir
    public ConsultaSaidaDTO buscarPorId(int id){
        Consulta consulta = consultaRepository.buscarPorId(id);
        if (consulta == null) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        return paraSaida(consulta);
    }

    // esse método agenda a consulta com status AGENDADA, se o horário existir e estiver livre (409 se estiver ocupado)
    public synchronized ConsultaSaidaDTO criar(ConsultaEntradaDTO dto){
        conferirHorarioECidadao(dto);
        if (consultaRepository.horarioOcupado(dto.getIdHorario())) {
            throw new HorarioIndisponivelException("Horário já ocupado por outra consulta");
        }
        Consulta consulta = new Consulta();
        consulta.setIdHorario(dto.getIdHorario());
        consulta.setIdCidadao(dto.getIdCidadao());
        consulta.setDsStatus("AGENDADA");
        consulta.setDtAgendamento(LocalDateTime.now());
        consulta.setVlProbFalta(dto.getVlProbFalta());
        consulta.setDsRiscoFalta(dto.getDsRiscoFalta());
        consulta.setIdOrientacao(dto.getIdOrientacao());
        return paraSaida(consultaRepository.inserir(consulta));
    }

    // esse método troca o horário ou o cidadão da consulta, conferindo se o novo horário está livre
    public synchronized ConsultaSaidaDTO atualizar(int id, ConsultaEntradaDTO dto){
        Consulta atual = consultaRepository.buscarPorId(id);
        if (atual == null) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        conferirHorarioECidadao(dto);
        if (dto.getIdHorario() != atual.getIdHorario() && consultaRepository.horarioOcupado(dto.getIdHorario())) {
            throw new HorarioIndisponivelException("Horário já ocupado por outra consulta");
        }
        atual.setIdHorario(dto.getIdHorario());
        atual.setIdCidadao(dto.getIdCidadao());
        consultaRepository.atualizar(atual);
        return paraSaida(atual);
    }

    // esse método muda o status da consulta e, se for CONFIRMADA, grava a data e o canal da confirmação
    public synchronized ConsultaSaidaDTO mudarStatus(int id, StatusConsultaDTO dto){
        Consulta consulta = consultaRepository.buscarPorId(id);
        if (consulta == null) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        String novoStatus = dto.getDsStatus();
        if (!statusAtivo(consulta.getDsStatus()) && statusAtivo(novoStatus) && consultaRepository.horarioOcupado(consulta.getIdHorario())) {
            throw new HorarioIndisponivelException("Horário já ocupado por outra consulta");
        }
        if ("CONFIRMADA".equals(novoStatus)) {
            if (dto.getDsCanalConfirmacao() == null) {
                throw new DadoInvalidoException("O canal de confirmação é obrigatório para confirmar a consulta");
            }
            consulta.setDtConfirmacao(LocalDateTime.now());
            consulta.setDsCanalConfirmacao(dto.getDsCanalConfirmacao());
        }
        if ("AGENDADA".equals(novoStatus)) {
            consulta.setDtConfirmacao(null);
            consulta.setDsCanalConfirmacao(null);
        }
        consulta.setDsStatus(novoStatus);
        consultaRepository.atualizar(consulta);
        return paraSaida(consulta);
    }

    // esse método apaga a consulta depois de conferir se ela existe
    public void remover(int id){
        buscarPorId(id);
        consultaRepository.remover(id);
    }
}
