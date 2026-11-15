package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.HorarioEntradaDTO;
import br.com.fiap.AcolheMais.dto.HorarioSaidaDTO;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import br.com.fiap.AcolheMais.model.Horario;
import br.com.fiap.AcolheMais.repository.ConsultaRepository;
import br.com.fiap.AcolheMais.repository.HorarioRepository;
import br.com.fiap.AcolheMais.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {
    private HorarioRepository horarioRepository;
    private UnidadeRepository unidadeRepository;
    private ConsultaRepository consultaRepository;

    public HorarioService(HorarioRepository horarioRepository, UnidadeRepository unidadeRepository, ConsultaRepository consultaRepository) {
        this.horarioRepository = horarioRepository;
        this.unidadeRepository = unidadeRepository;
        this.consultaRepository = consultaRepository;
    }

    private Horario paraModel(HorarioEntradaDTO dto){
        Horario horario = new Horario();
        horario.setDtHorario(dto.getDtHorario());
        horario.setNrDuracaoMinuto(dto.getNrDuracaoMinuto());
        return horario;
    }

    private HorarioSaidaDTO paraSaida(Horario horario){
        HorarioSaidaDTO saida = new HorarioSaidaDTO(horario.getIdHorario(), horario.getIdUnidade(), horario.getDtHorario(), horario.getNrDuracaoMinuto());
        saida.setFlOcupado(consultaRepository.horarioOcupado(horario.getIdHorario()));
        return saida;
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
