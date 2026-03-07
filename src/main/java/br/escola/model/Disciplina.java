package br.escola.model;

public class Disciplina {

    private int id;
    private String nomeDisciplina;

    public Disciplina(int id, String nome) {
        this.id = id;
        this.nomeDisciplina = nome;
    }

    public String getNome() {
        return nomeDisciplina;
    }
}