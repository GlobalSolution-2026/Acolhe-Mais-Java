package br.com.fiap.AcolheMais.handler;

import br.com.fiap.AcolheMais.dto.ErroDTO;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> tratarNaoEncontrado(RecursoNaoEncontradoException e){
        ErroDTO erro = new ErroDTO(404, e.getMessage());
        return ResponseEntity.status(404).body(erro);
    }
}
