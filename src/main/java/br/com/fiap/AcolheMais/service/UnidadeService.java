package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.UnidadeEntradaDTO;
import br.com.fiap.AcolheMais.dto.UnidadeSaidaDTO;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import br.com.fiap.AcolheMais.model.Unidade;
import br.com.fiap.AcolheMais.repository.HorarioRepository;
import br.com.fiap.AcolheMais.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service da unidade: CRUD e bloqueio da remoção de unidade que tem horários.
 *
 * @author Nicolas Martins
 */
@Service
public class UnidadeService {
    private UnidadeRepository unidadeRepository;
    private HorarioRepository horarioRepository;

    public UnidadeService(UnidadeRepository unidadeRepository, HorarioRepository horarioRepository) {
        this.unidadeRepository = unidadeRepository;
        this.horarioRepository = horarioRepository;
    }

    // esse método converte os dados que chegaram (DTO) em um objeto Unidade
    private Unidade paraModel(UnidadeEntradaDTO dto){
        Unidade unidade = new Unidade();
        unidade.setNmUnidade(dto.getNmUnidade());
        unidade.setTpUnidade(dto.getTpUnidade());
        unidade.setDsEndereco(dto.getDsEndereco());
        unidade.setNrCep(dto.getNrCep());
        unidade.setNrTelefone(dto.getNrTelefone());
        return unidade;
    }

    // esse método converte a Unidade em DTO de saída
    private UnidadeSaidaDTO paraSaida(Unidade unidade){
        return new UnidadeSaidaDTO(unidade.getNmUnidade(), unidade.getTpUnidade(), unidade.getDsEndereco(), unidade.getNrCep(), unidade.getNrTelefone(), unidade.getIdUnidade());
    }

    // esse método devolve todas as unidades
    public List<UnidadeSaidaDTO> listar(){
        List<UnidadeSaidaDTO> lista = new ArrayList<>();
        for (Unidade unidade : unidadeRepository.listar()) {
            lista.add(paraSaida(unidade));
        }
        return lista;
    }

    // esse método busca a unidade pelo id e lança 404 se não existir
    public UnidadeSaidaDTO buscarPorId(int id){
        Unidade unidade = unidadeRepository.buscarPorId(id);
        if (unidade == null) {
            throw new RecursoNaoEncontradoException("Unidade não encontrada");
        }
        return paraSaida(unidade);
    }

    // esse método cadastra uma nova unidade
    public UnidadeSaidaDTO criar(UnidadeEntradaDTO dto){
        Unidade unidade = unidadeRepository.inserir(paraModel(dto));
        return paraSaida(unidade);
    }

    // esse método altera os dados da unidade depois de conferir se ela existe
    public UnidadeSaidaDTO atualizar(int id, UnidadeEntradaDTO dto){
        buscarPorId(id);
        Unidade unidade = paraModel(dto);
        unidade.setIdUnidade(id);
        unidadeRepository.atualizar(unidade);
        return paraSaida(unidade);
    }

    // esse método apaga a unidade, mas lança 409 se ela ainda tiver horários
    public void remover(int id){
        buscarPorId(id);
        if (horarioRepository.unidadePossuiHorarios(id)) {
            throw new RegraNegocioException("Não é possível remover uma unidade que possui horários");
        }
        unidadeRepository.remover(id);
    }
}
