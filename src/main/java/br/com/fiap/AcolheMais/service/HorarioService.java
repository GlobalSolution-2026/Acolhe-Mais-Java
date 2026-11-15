package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.HorarioEntradaDTO;
import br.com.fiap.AcolheMais.dto.HorarioSaidaDTO;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import br.com.fiap.AcolheMais.model.Horario;
import br.com.fiap.AcolheMais.repository.HorarioRepository;
import br.com.fiap.AcolheMais.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {
    private HorarioRepository horarioRepository;
    private UnidadeRepository unidadeRepository;

    public HorarioService(HorarioRepository horarioRepository, UnidadeRepository unidadeRepository) {
        this.horarioRepository = horarioRepository;
        this.unidadeRepository = unidadeRepository;
    }

    private Horario paraModel(HorarioEntradaDTO dto){
        Horario horario = new Horario();
        horario.setDtHorario(dto.getDtHorario());
        horario.setNrDuracaoMinuto(dto.getNrDuracaoMinuto());
        return horario;
    }

    private HorarioSaidaDTO paraSaida(Horario horario){
        return new HorarioSaidaDTO(horario.getIdHorario(), horario.getIdUnidade(), horario.getDtHorario(), horario.getNrDuracaoMinuto());
    }

    private void validar(HorarioEntradaDTO dto){
        if (dto.getDtHorario() == null) {
            throw new DadoInvalidoException("Data e hora são obrigatórias");
        }
        if (dto.getDtHorario().isBefore(LocalDateTime.now())) {
            throw new DadoInvalidoException("O horário deve estar no futuro");
        }
        if (dto.getNrDuracaoMinuto() <= 0) {
            throw new DadoInvalidoException("A duração deve ser maior que zero");
        }
        if (dto.getNrDuracaoMinuto() > 240) {
            throw new DadoInvalidoException("A duração deve ser de no máximo 240 minutos");
        }
    }

    private void conferirUnidade(int idUnidade){
        if (unidadeRepository.buscarPorId(idUnidade) == null) {
            throw new RecursoNaoEncontradoException("Unidade não encontrada");
        }
    }

    public List<HorarioSaidaDTO> listarPorUnidade(int idUnidade){
        conferirUnidade(idUnidade);
        List<HorarioSaidaDTO> lista = new ArrayList<>();
        for (Horario horario : horarioRepository.listarPorUnidade(idUnidade)) {
            lista.add(paraSaida(horario));
        }
        return lista;
    }

    public HorarioSaidaDTO criar(int idUnidade, HorarioEntradaDTO dto){
        conferirUnidade(idUnidade);
        validar(dto);
        if (horarioRepository.existeHorario(idUnidade, dto.getDtHorario())) {
            throw new RegraNegocioException("Já existe um horário igual nesta unidade");
        }
        Horario horario = paraModel(dto);
        horario.setIdUnidade(idUnidade);
        return paraSaida(horarioRepository.inserir(horario));
    }

    public HorarioSaidaDTO buscarPorId(int id){
        Horario horario = horarioRepository.buscarPorId(id);
        if (horario == null) {
            throw new RecursoNaoEncontradoException("Horário não encontrado");
        }
        return paraSaida(horario);
    }

    public HorarioSaidaDTO atualizar(int id, HorarioEntradaDTO dto){
        Horario atual = horarioRepository.buscarPorId(id);
        if (atual == null) {
            throw new RecursoNaoEncontradoException("Horário não encontrado");
        }
        validar(dto);
        if (!dto.getDtHorario().equals(atual.getDtHorario()) && horarioRepository.existeHorario(atual.getIdUnidade(), dto.getDtHorario())) {
            throw new RegraNegocioException("Já existe um horário igual nesta unidade");
        }
        Horario horario = paraModel(dto);
        horario.setIdHorario(id);
        horario.setIdUnidade(atual.getIdUnidade());
        horarioRepository.atualizar(horario);
        return paraSaida(horario);
    }

    public void remover(int id){
        buscarPorId(id);
        horarioRepository.remover(id);
    }
}
