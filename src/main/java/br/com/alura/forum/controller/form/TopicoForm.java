package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.alura.forum.modelo.Topico;

public class TopicoForm {

    @NotBlank
    @Size(min = 5)
    private String titulo;
    @NotBlank
    @Size(min = 10)
    private String mensagem;
    @NotBlank
    private String nomeCurso;

    public TopicoForm() {
        super();
    }

    public Topico converter() {
        return new Topico(titulo, mensagem);
    }

    public TopicoForm(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

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

    public String getNomeCurso() {
        return this.nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

}
