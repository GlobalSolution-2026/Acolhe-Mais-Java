package br.com.fiap.AcolheMais.exception;

/**
 * Exception lançada quando o registro buscado pelo id não existe (404).
 *
 * @author Nicolas Martins
 */
public class RecursoNaoEncontradoException extends RuntimeException{
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
