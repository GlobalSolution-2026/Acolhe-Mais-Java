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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
