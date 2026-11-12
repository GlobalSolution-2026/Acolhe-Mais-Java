package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.UnidadeEntradaDTO;
import br.com.fiap.AcolheMais.dto.UnidadeSaidaDTO;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.model.Unidade;
import br.com.fiap.AcolheMais.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadeService {
    private UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    private Unidade paraModel(UnidadeEntradaDTO dto){
        Unidade unidade = new Unidade();
        unidade.setNmUnidade(dto.getNmUnidade());
        unidade.setTpUnidade(dto.getTpUnidade());
        unidade.setDsEndereco(dto.getDsEndereco());
        unidade.setNrCep(dto.getNrCep());
        unidade.setNrTelefone(dto.getNrTelefone());
        return unidade;
    }

    private UnidadeSaidaDTO paraSaida(Unidade unidade){
        return new UnidadeSaidaDTO(unidade.getNmUnidade(), unidade.getTpUnidade(), unidade.getDsEndereco(), unidade.getNrCep(), unidade.getNrTelefone(), unidade.getIdUnidade());
    }

    private void validar(UnidadeEntradaDTO dto){
        if (dto.getNmUnidade() == null || dto.getNmUnidade().isBlank()) {
            throw new DadoInvalidoException("Nome da unidade é obrigatório");
        }
        if (dto.getDsEndereco() == null || dto.getDsEndereco().isBlank()) {
            throw new DadoInvalidoException("Endereço é obrigatório");
        }
        if (!"UBS".equals(dto.getTpUnidade()) && !"UPA".equals(dto.getTpUnidade())) {
            throw new DadoInvalidoException("Tipo deve ser UBS ou UPA");
        }
    }

    public List<UnidadeSaidaDTO> listar(){
        List<UnidadeSaidaDTO> lista = new ArrayList<>();
        for (Unidade unidade : unidadeRepository.listar()) {
            lista.add(paraSaida(unidade));
        }
        return lista;
    }

    public UnidadeSaidaDTO buscarPorId(int id){
        Unidade unidade = unidadeRepository.buscarPorId(id);
        if (unidade == null) {
            throw new RecursoNaoEncontradoException("Unidade não encontrada");
        }
        return paraSaida(unidade);
    }

    public UnidadeSaidaDTO criar(UnidadeEntradaDTO dto){
        validar(dto);
        Unidade unidade = unidadeRepository.inserir(paraModel(dto));
        return paraSaida(unidade);
    }

    public UnidadeSaidaDTO atualizar(int id, UnidadeEntradaDTO dto){
        buscarPorId(id);
        validar(dto);
        Unidade unidade = paraModel(dto);
        unidade.setIdUnidade(id);
        unidadeRepository.atualizar(unidade);
        return paraSaida(unidade);
    }

    public void remover(int id){
        buscarPorId(id);
        unidadeRepository.remover(id);
    }
}
