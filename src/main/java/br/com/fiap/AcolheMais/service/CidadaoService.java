package br.com.fiap.AcolheMais.service;

import br.com.fiap.AcolheMais.dto.CidadaoEntradaDTO;
import br.com.fiap.AcolheMais.dto.CidadaoSaidaDTO;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import br.com.fiap.AcolheMais.model.Cidadao;
import br.com.fiap.AcolheMais.repository.CidadaoRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

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
        if (vazio(dto.getNmCidadao())) {
            throw new DadoInvalidoException("Nome do cidadão é obrigatório");
        }
        if (dto.getNrCns() == null || dto.getNrCns().length() != 15) {
            throw new DadoInvalidoException("O CNS deve ter exatamente 15 caracteres");
        }
        if (!vazio(dto.getNrCpf()) && dto.getNrCpf().length() != 11) {
            throw new DadoInvalidoException("O CPF deve ter 11 caracteres");
        }
        if (dto.getDtNascimento() == null || !dto.getDtNascimento().isBefore(LocalDate.now())) {
            throw new DadoInvalidoException("A data de nascimento deve estar no passado");
        }
        if (!"F".equals(dto.getDsSexo()) && !"M".equals(dto.getDsSexo())) {
            throw new DadoInvalidoException("Sexo deve ser F ou M");
        }
        if (!"SENHA".equals(dto.getTpAcesso()) && !"BALCAO".equals(dto.getTpAcesso())) {
            throw new DadoInvalidoException("Tipo de acesso deve ser SENHA ou BALCAO");
        }
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

    public CidadaoSaidaDTO atualizar(int id, CidadaoEntradaDTO dto){
        Cidadao atual = cidadaoRepository.buscarPorId(id);
        if (atual == null) {
            throw new RecursoNaoEncontradoException("Cidadão não encontrado");
        }
        validar(dto);
        if (!dto.getNrCns().equals(atual.getNrCns()) && cidadaoRepository.existeCns(dto.getNrCns())) {
            throw new RegraNegocioException("Já existe um cidadão com este CNS");
        }
        if (!vazio(dto.getNrCpf()) && !dto.getNrCpf().equals(atual.getNrCpf()) && cidadaoRepository.existeCpf(dto.getNrCpf())) {
            throw new RegraNegocioException("Já existe um cidadão com este CPF");
        }
        Cidadao cidadao = paraModel(dto);
        cidadao.setIdCidadao(id);
        cidadaoRepository.atualizar(cidadao);
        return paraSaida(cidadao);
    }

    public void remover(int id){
        buscarPorId(id);
        cidadaoRepository.remover(id);
    }
}
