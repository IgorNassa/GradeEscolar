package br.escola.model;

public class Professor {
    private Long id;
    private String nome;
    private String disciplinaLecionada;

    public Professor(Long id, String nome, String disciplinaLecionada) {
        this.id = id;
        this.nome = nome;
        this.disciplinaLecionada = disciplinaLecionada;
    }

    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplinaLecionada() {
        return disciplinaLecionada;
    }

    public void setDisciplinaLecionada(String disciplinaLecionada) {
        this.disciplinaLecionada = disciplinaLecionada;
    }
}
