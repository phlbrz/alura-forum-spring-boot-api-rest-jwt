package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizacaoTopicoForm {

    @NotBlank
    @Size(min = 5)
    private String titulo;
    @NotBlank
    @Size(min = 10)
    private String mensagem;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
