package br.com.fiap.AcolheMais.controller;

import br.com.fiap.AcolheMais.dto.CidadaoAtualizacaoDTO;
import br.com.fiap.AcolheMais.dto.CidadaoEntradaDTO;
import br.com.fiap.AcolheMais.dto.CidadaoSaidaDTO;
import br.com.fiap.AcolheMais.dto.LoginDTO;
import br.com.fiap.AcolheMais.service.CidadaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * Controller REST das rotas de /cidadaos: CRUD, login e busca por Cartão SUS.
 *
 * @author Nicolas Martins
 */
@RestController
@RequestMapping("/cidadaos")
public class CidadaoController {
    private CidadaoService cidadaoService;

    public CidadaoController(CidadaoService cidadaoService) {
        this.cidadaoService = cidadaoService;
    }

    // esse método cadastra um novo cidadão e devolve 201 com o endereço (Location) dele
    @PostMapping
    public ResponseEntity<CidadaoSaidaDTO> criar(@Valid @RequestBody CidadaoEntradaDTO dto){
        CidadaoSaidaDTO cidadao = cidadaoService.criar(dto);
        return ResponseEntity.created(URI.create("/cidadaos/" + cidadao.getIdCidadao())).body(cidadao);
    }

    // esse método devolve a lista de todos os cidadãos
    @GetMapping
    public ResponseEntity<List<CidadaoSaidaDTO>> listar(){
        return ResponseEntity.ok(cidadaoService.listar());
    }

    // esse método busca um cidadão pelo número do Cartão SUS (404 se não achar)
    @GetMapping(params = "cns")
    public ResponseEntity<CidadaoSaidaDTO> buscarPorCns(@RequestParam String cns){
        return ResponseEntity.ok(cidadaoService.buscarPorCns(cns));
    }

    // esse método confere o Cartão SUS e a senha e devolve o cidadão se estiverem certos (401 se estiverem errados)
    @PostMapping("/login")
    public ResponseEntity<CidadaoSaidaDTO> login(@Valid @RequestBody LoginDTO dto){
        return ResponseEntity.ok(cidadaoService.login(dto));
    }

    // esse método devolve o cidadão do id informado (404 se não existir)
    @GetMapping("/{id}")
    public ResponseEntity<CidadaoSaidaDTO> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(cidadaoService.buscarPorId(id));
    }

    // esse método altera só o contato e o CEP do cidadão do id informado
    @PutMapping("/{id}")
    public ResponseEntity<CidadaoSaidaDTO> atualizar(@PathVariable int id, @Valid @RequestBody CidadaoAtualizacaoDTO dto){
        return ResponseEntity.ok(cidadaoService.atualizar(id, dto));
    }

    // esse método apaga o cidadão do id informado e devolve 204 (sem conteúdo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        cidadaoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
