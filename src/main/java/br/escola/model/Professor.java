package br.escola.model;

public class Professor {
    private Long id;
    private String nome;
    private Disciplina disciplinaLecionada;

    public Professor(Long id, String nome, Disciplina disciplinaLecionada) {
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

    public Disciplina getDisciplinaLecionada() {
        return disciplinaLecionada;
    }

    public void setDisciplinaLecionada(Disciplina disciplinaLecionada) {
        this.disciplinaLecionada = disciplinaLecionada;
    }
}
