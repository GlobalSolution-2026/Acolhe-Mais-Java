package br.com.fiap.AcolheMais.controller;

import br.com.fiap.AcolheMais.dto.ConsultaEntradaDTO;
import br.com.fiap.AcolheMais.dto.ConsultaSaidaDTO;
import br.com.fiap.AcolheMais.dto.StatusConsultaDTO;
import br.com.fiap.AcolheMais.service.ConsultaService;
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

/**
 * Controller REST das rotas de /consultas: CRUD e troca de status da consulta.
 *
 * @author Nicolas Martins
 */
@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    // esse método agenda uma nova consulta e devolve 201 com o endereço (Location) dela
    @PostMapping
    public ResponseEntity<ConsultaSaidaDTO> criar(@Valid @RequestBody ConsultaEntradaDTO dto){
        ConsultaSaidaDTO consulta = consultaService.criar(dto);
        return ResponseEntity.created(URI.create("/consultas/" + consulta.getIdConsulta())).body(consulta);
    }

    // esse método devolve a lista de todas as consultas
    @GetMapping
    public ResponseEntity<List<ConsultaSaidaDTO>> listar(){
        return ResponseEntity.ok(consultaService.listar());
    }

    // esse método devolve a consulta do id informado (404 se não existir)
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaSaidaDTO> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(consultaService.buscarPorId(id));
    }

    // esse método troca o horário ou o cidadão da consulta do id informado
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaSaidaDTO> atualizar(@PathVariable int id, @Valid @RequestBody ConsultaEntradaDTO dto){
        return ResponseEntity.ok(consultaService.atualizar(id, dto));
    }

    // esse método muda o status da consulta (confirmar, cancelar, registrar presença ou falta)
    @PutMapping("/{id}/status")
    public ResponseEntity<ConsultaSaidaDTO> mudarStatus(@PathVariable int id, @Valid @RequestBody StatusConsultaDTO dto){
        return ResponseEntity.ok(consultaService.mudarStatus(id, dto));
    }

    // esse método apaga a consulta do id informado e devolve 204 (sem conteúdo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        consultaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
