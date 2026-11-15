package br.com.fiap.AcolheMais.handler;

import br.com.fiap.AcolheMais.dto.ErroDTO;
import br.com.fiap.AcolheMais.exception.CredenciaisInvalidasException;
import br.com.fiap.AcolheMais.exception.DadoInvalidoException;
import br.com.fiap.AcolheMais.exception.HorarioIndisponivelException;
import br.com.fiap.AcolheMais.exception.RecursoNaoEncontradoException;
import br.com.fiap.AcolheMais.exception.RegraNegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLException;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> tratarValidacao(MethodArgumentNotValidException e){
        String mensagem = "Dados inválidos";
        FieldError campo = e.getBindingResult().getFieldError();
        if (campo != null) {
            mensagem = campo.getDefaultMessage();
        }
        ErroDTO erro = new ErroDTO(400, mensagem);
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(CredenciaisInvalidasException.class)
    public ResponseEntity<ErroDTO> tratarLogin(CredenciaisInvalidasException e){
        ErroDTO erro = new ErroDTO(401, e.getMessage());
        return ResponseEntity.status(401).body(erro);
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroDTO> tratarCorpoInvalido(HttpMessageNotReadableException e){
        ErroDTO erro = new ErroDTO(400, "Corpo da requisição ausente ou inválido");
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroDTO> tratarParametroInvalido(MethodArgumentTypeMismatchException e){
        ErroDTO erro = new ErroDTO(400, "Parâmetro inválido na URL");
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErroDTO> tratarRotaInexistente(NoResourceFoundException e){
        ErroDTO erro = new ErroDTO(404, "Rota não encontrada");
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErroDTO> tratarTipoNaoSuportado(HttpMediaTypeNotSupportedException e){
        ErroDTO erro = new ErroDTO(415, "Tipo de conteúdo não suportado, use application/json");
        return ResponseEntity.status(415).body(erro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDTO> tratarErroDeBanco(RuntimeException e){
        if (e.getCause() instanceof SQLException) {
            SQLException erroSql = (SQLException) e.getCause();
            int codigo = erroSql.getErrorCode();
            if (codigo == 2292) {
                ErroDTO erro = new ErroDTO(409, "Não é possível remover: existem registros vinculados");
                return ResponseEntity.status(409).body(erro);
            }
            if (codigo == 1) {
                ErroDTO erro = new ErroDTO(409, "Já existe um registro com esses dados");
                return ResponseEntity.status(409).body(erro);
            }
            if (codigo == 12899 || codigo == 1438 || codigo == 2290 || codigo == 2291) {
                ErroDTO erro = new ErroDTO(400, "Algum campo tem tamanho ou valor fora do permitido");
                return ResponseEntity.status(400).body(erro);
            }
        }
        return tratarErroInesperado(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> tratarErroInesperado(Exception e){
        ErroDTO erro = new ErroDTO(500, "Erro interno no servidor");
        return ResponseEntity.status(500).body(erro);
    }
}
