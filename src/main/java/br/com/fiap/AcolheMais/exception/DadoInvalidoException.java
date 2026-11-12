package br.com.fiap.AcolheMais.exception;

public class DadoInvalidoException extends RuntimeException{
    public DadoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
