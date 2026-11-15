package br.com.fiap.AcolheMais.handler;

import br.com.fiap.AcolheMais.dto.ErroDTO;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.HorarioIndisponivelException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> tratarNaoEncontrado(RecursoNaoEncontradoException e){
        ErroDTO erro = new ErroDTO(404, e.getMessage());
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(DadoInvalidoException.class)
    public ResponseEntity<ErroDTO> tratarDadoInvalido(DadoInvalidoException e){
        ErroDTO erro = new ErroDTO(400, e.getMessage());
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ErroDTO> tratarRegraNegocio(RegraNegocioException e){
        ErroDTO erro = new ErroDTO(409, e.getMessage());
        return ResponseEntity.status(409).body(erro);
    }

    @ExceptionHandler(HorarioIndisponivelException.class)
    public ResponseEntity<ErroDTO> tratarHorarioIndisponivel(HorarioIndisponivelException e){
        ErroDTO erro = new ErroDTO(409, e.getMessage());
        return ResponseEntity.status(409).body(erro);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroDTO> tratarMetodoNaoSuportado(HttpRequestMethodNotSupportedException e){
        ErroDTO erro = new ErroDTO(405, "Método HTTP não suportado nesta rota");
        return ResponseEntity.status(405).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> tratarErroInesperado(Exception e){
        ErroDTO erro = new ErroDTO(500, "Erro interno no servidor");
        return ResponseEntity.status(500).body(erro);
    }
}
