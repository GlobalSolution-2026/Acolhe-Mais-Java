package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.CidadaoAtualizacaoDTO;
import br.com.fiap.AcolheMais.dto.CidadaoEntradaDTO;
import br.com.fiap.AcolheMais.dto.CidadaoSaidaDTO;
import br.com.fiap.AcolheMais.dto.LoginDTO;
import br.com.fiap.AcolheMais.exception.CredenciaisInvalidasException;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import br.com.fiap.AcolheMais.model.Cidadao;
import br.com.fiap.AcolheMais.repository.CidadaoRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

/**
 * Service do cidadão: regras de CNS e CPF únicos, hash da senha, login e CRUD.
 *
 * @author Nicolas Martins
 */
@Service
public class CidadaoService {
    private CidadaoRepository cidadaoRepository;

    public CidadaoService(CidadaoRepository cidadaoRepository) {
        this.cidadaoRepository = cidadaoRepository;
    }

    private Cidadao paraModel(CidadaoEntradaDTO dto){
        Cidadao cidadao = new Cidadao();
        cidadao.setNmCidadao(dto.getNmCidadao());
        cidadao.setNrCns(dto.getNrCns());
        cidadao.setNrCpf(dto.getNrCpf());
        cidadao.setDtNascimento(dto.getDtNascimento());
        cidadao.setDsSexo(dto.getDsSexo());
        cidadao.setNrCelular(dto.getNrCelular());
        cidadao.setNmContatoRecado(dto.getNmContatoRecado());
        cidadao.setNrContatoRecado(dto.getNrContatoRecado());
        cidadao.setNrCep(dto.getNrCep());
        cidadao.setTpAcesso(dto.getTpAcesso());
        if (!vazio(dto.getSenha())) {
            cidadao.setDsSenhaHash(gerarHash(dto.getSenha()));
        }
        return cidadao;
    }

    private String gerarHash(String senha){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar o hash da senha", e);
        }
    }

    private CidadaoSaidaDTO paraSaida(Cidadao cidadao){
        return new CidadaoSaidaDTO(cidadao.getIdCidadao(), cidadao.getNmCidadao(), cidadao.getNrCns(), cidadao.getNrCpf(), cidadao.getDtNascimento(), cidadao.getDsSexo(), cidadao.getNrCelular(), cidadao.getNmContatoRecado(), cidadao.getNrContatoRecado(), cidadao.getNrCep(), cidadao.getTpAcesso());
    }

    private boolean vazio(String texto){
        return texto == null || texto.isBlank();
    }

    private void validar(CidadaoEntradaDTO dto){
        if ("SENHA".equals(dto.getTpAcesso()) && vazio(dto.getSenha())) {
            throw new DadoInvalidoException("A senha é obrigatória para acesso por senha");
        }
    }

    public List<CidadaoSaidaDTO> listar(){
        List<CidadaoSaidaDTO> lista = new ArrayList<>();
        for (Cidadao cidadao : cidadaoRepository.listar()) {
            lista.add(paraSaida(cidadao));
        }
        return lista;
    }

    public CidadaoSaidaDTO buscarPorId(int id){
        Cidadao cidadao = cidadaoRepository.buscarPorId(id);
        if (cidadao == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
        return paraSaida(cidadao);
    }

    public CidadaoSaidaDTO buscarPorCns(String nrCns){
        Cidadao cidadao = cidadaoRepository.buscarPorCns(nrCns);
        if (cidadao == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
        return paraSaida(cidadao);
    }

    public CidadaoSaidaDTO criar(CidadaoEntradaDTO dto){
        validar(dto);
        if (cidadaoRepository.existeCns(dto.getNrCns())) {
            throw new RegraNegocioException("Já existe um cidadão com este CNS");
        }
        if (!vazio(dto.getNrCpf()) && cidadaoRepository.existeCpf(dto.getNrCpf())) {
            throw new RegraNegocioException("Já existe um cidadão com este CPF");
        }
        Cidadao cidadao = cidadaoRepository.inserir(paraModel(dto));
        return paraSaida(cidadao);
    }

    public CidadaoSaidaDTO atualizar(int id, CidadaoAtualizacaoDTO dto){
        Cidadao cidadao = cidadaoRepository.buscarPorId(id);
        if (cidadao == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
        cidadao.setNrCelular(dto.getNrCelular());
        cidadao.setNmContatoRecado(dto.getNmContatoRecado());
        cidadao.setNrContatoRecado(dto.getNrContatoRecado());
        cidadao.setNrCep(dto.getNrCep());
        cidadaoRepository.atualizar(cidadao);
        return paraSaida(cidadao);
    }

    public CidadaoSaidaDTO login(LoginDTO dto){
        Cidadao cidadao = cidadaoRepository.buscarPorCns(dto.getNrCns());
        if (cidadao == null || cidadao.getDsSenhaHash() == null || !cidadao.getDsSenhaHash().equals(gerarHash(dto.getSenha()))) {
            throw new CredenciaisInvalidasException("Cartão SUS ou senha incorretos.");
        }
        return paraSaida(cidadao);
    }

    public void remover(int id){
        buscarPorId(id);
        cidadaoRepository.remover(id);
    }
}
