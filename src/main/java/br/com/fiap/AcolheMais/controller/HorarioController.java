package br.com.fiap.AcolheMais.controller;

import br.com.fiap.AcolheMais.dto.HorarioEntradaDTO;
import br.com.fiap.AcolheMais.dto.HorarioSaidaDTO;
import br.com.fiap.AcolheMais.service.HorarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * Controller REST dos horários, com rotas aninhadas em /unidades e rotas próprias em /horarios.
 *
 * @author Nicolas Martins
 */
@RestController
public class HorarioController {
    private HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    // esse método devolve todos os horários de uma unidade
    @GetMapping("/unidades/{idUnidade}/horarios")
    public ResponseEntity<List<HorarioSaidaDTO>> listarPorUnidade(@PathVariable int idUnidade){
        return ResponseEntity.ok(horarioService.listarPorUnidade(idUnidade));
    }

    // esse método cadastra um novo horário dentro de uma unidade e devolve 201 com o endereço (Location) dele
    @PostMapping("/unidades/{idUnidade}/horarios")
    public ResponseEntity<HorarioSaidaDTO> criar(@PathVariable int idUnidade, @Valid @RequestBody HorarioEntradaDTO dto){
        HorarioSaidaDTO horario = horarioService.criar(idUnidade, dto);
        return ResponseEntity.created(URI.create("/horarios/" + horario.getIdHorario())).body(horario);
    }

    // esse método devolve o horário do id informado (404 se não existir)
    @GetMapping("/horarios/{id}")
    public ResponseEntity<HorarioSaidaDTO> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(horarioService.buscarPorId(id));
    }

    // esse método altera a data, a hora e a duração do horário do id informado
    @PutMapping("/horarios/{id}")
    public ResponseEntity<HorarioSaidaDTO> atualizar(@PathVariable int id, @Valid @RequestBody HorarioEntradaDTO dto){
        return ResponseEntity.ok(horarioService.atualizar(id, dto));
    }

    // esse método apaga o horário do id informado e devolve 204 (sem conteúdo)
    @DeleteMapping("/horarios/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        horarioService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
