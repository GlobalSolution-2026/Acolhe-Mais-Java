package br.com.fiap.AcolheMais.exception;

public class CredenciaisInvalidasException extends RuntimeException{
    public CredenciaisInvalidasException(String mensagem) {
        super(mensagem);
    }
}
