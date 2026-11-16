package br.com.fiap.AcolheMais.exception;

/**
 * Exception lançada quando o Cartão SUS ou a senha do login estão incorretos (401).
 *
 * @author Nicolas Martins
 */
public class CredenciaisInvalidasException extends RuntimeException{
    public CredenciaisInvalidasException(String mensagem) {
        super(mensagem);
    }
}
