package br.com.fiap.AcolheMais.exception;

/**
 * Exception lançada quando uma regra de negócio é violada, como duplicidade (409).
 *
 * @author Nicolas Martins
 */
public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}
