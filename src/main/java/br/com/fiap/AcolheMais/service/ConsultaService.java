package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.ConsultaEntradaDTO;
import br.com.fiap.AcolheMais.dto.ConsultaSaidaDTO;
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

    private ConsultaSaidaDTO paraSaida(Consulta consulta){
        Horario horario = horarioRepository.buscarPorId(consulta.getIdHorario());
        Unidade unidade = unidadeRepository.buscarPorId(horario.getIdUnidade());
        Cidadao cidadao = cidadaoRepository.buscarPorId(consulta.getIdCidadao());
        return new ConsultaSaidaDTO(consulta.getIdConsulta(), unidade.getNmUnidade(), horario.getDtHorario(), cidadao.getNmCidadao(), consulta.getDsStatus());
    }

    private void validar(ConsultaEntradaDTO dto){
        if (dto.getIdHorario() <= 0) {
            throw new DadoInvalidoException("O horário é obrigatório");
        }
        if (dto.getIdCidadao() <= 0) {
            throw new DadoInvalidoException("O cidadão é obrigatório");
        }
    }

    private void conferirHorarioECidadao(ConsultaEntradaDTO dto){
        if (horarioRepository.buscarPorId(dto.getIdHorario()) == null) {
            throw new RecursoNaoEncontradoException("Horário não encontrado");
        }
        if (cidadaoRepository.buscarPorId(dto.getIdCidadao()) == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
    }

    public List<ConsultaSaidaDTO> listar(){
        List<ConsultaSaidaDTO> lista = new ArrayList<>();
        for (Consulta consulta : consultaRepository.listar()) {
            lista.add(paraSaida(consulta));
        }
        return lista;
    }

    public ConsultaSaidaDTO buscarPorId(int id){
        Consulta consulta = consultaRepository.buscarPorId(id);
        if (consulta == null) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        return paraSaida(consulta);
    }

    public ConsultaSaidaDTO criar(ConsultaEntradaDTO dto){
        validar(dto);
        conferirHorarioECidadao(dto);
        if (consultaRepository.horarioOcupado(dto.getIdHorario())) {
            throw new HorarioIndisponivelException("Horário já ocupado por outra consulta");
        }
        Consulta consulta = new Consulta();
        consulta.setIdHorario(dto.getIdHorario());
        consulta.setIdCidadao(dto.getIdCidadao());
        consulta.setDsStatus("AGENDADA");
        consulta.setDtAgendamento(LocalDateTime.now());
        return paraSaida(consultaRepository.inserir(consulta));
    }

    public ConsultaSaidaDTO atualizar(int id, ConsultaEntradaDTO dto){
        Consulta atual = consultaRepository.buscarPorId(id);
        if (atual == null) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        validar(dto);
        conferirHorarioECidadao(dto);
        if (dto.getIdHorario() != atual.getIdHorario() && consultaRepository.horarioOcupado(dto.getIdHorario())) {
            throw new HorarioIndisponivelException("Horário já ocupado por outra consulta");
        }
        atual.setIdHorario(dto.getIdHorario());
        atual.setIdCidadao(dto.getIdCidadao());
        consultaRepository.atualizar(atual);
        return paraSaida(atual);
    }

    public void remover(int id){
        buscarPorId(id);
        consultaRepository.remover(id);
    }
}
