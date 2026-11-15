package br.com.fiap.AcolheMais.controller;

import br.com.fiap.AcolheMais.dto.UnidadeEntradaDTO;
import br.com.fiap.AcolheMais.dto.UnidadeSaidaDTO;
import br.com.fiap.AcolheMais.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping
    public ResponseEntity<UnidadeSaidaDTO> criar(@Valid @RequestBody UnidadeEntradaDTO dto){
        UnidadeSaidaDTO unidade = unidadeService.criar(dto);
        return ResponseEntity.created(URI.create("/unidades/" + unidade.getIdUnidade())).body(unidade);
    }

    @GetMapping
    public ResponseEntity<List<UnidadeSaidaDTO>> listar(){
        return ResponseEntity.ok(unidadeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeSaidaDTO> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(unidadeService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeSaidaDTO> atualizar(@PathVariable int id, @Valid @RequestBody UnidadeEntradaDTO dto){
        return ResponseEntity.ok(unidadeService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        unidadeService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
