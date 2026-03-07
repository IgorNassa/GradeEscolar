package br.escola.model;

public class Professor {

    private int id;
    private String nome;
    private Disciplina disciplina;

    public Professor(int id, String nome, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
    }
    public String getNome() {
        return nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}