package br.com.fiap.AcolheMais.dto;

/**
 * DTO padrão de erro da API, com o status HTTP e a mensagem lida pelo front.
 *
 * @author Nicolas Martins
 */
public class ErroDTO {
    private int status;
    private String mensagem;

    public ErroDTO(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    // esse método devolve o código de status do erro
    public int getStatus() {
        return status;
    }

    // esse método altera o código de status do erro
    public void setStatus(int status) {
        this.status = status;
    }

    // esse método devolve a mensagem do erro
    public String getMensagem() {
        return mensagem;
    }

    // esse método altera a mensagem do erro
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
