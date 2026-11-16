package br.com.fiap.AcolheMais.exception;

/**
 * Exception lançada quando um dado enviado viola uma regra de validação (400).
 *
 * @author Nicolas Martins
 */
public class DadoInvalidoException extends RuntimeException{
    public DadoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
