package br.com.fiap.AcolheMais.exception;

/**
 * Exception lançada quando o horário já tem consulta agendada ou confirmada (409).
 *
 * @author Nicolas Martins
 */
public class HorarioIndisponivelException extends RuntimeException{
    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
