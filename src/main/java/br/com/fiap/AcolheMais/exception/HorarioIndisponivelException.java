package br.com.fiap.AcolheMais.exception;

public class HorarioIndisponivelException extends RuntimeException{
    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
