package br.escola.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Long id;
    private String nome;
    private List<String> materiasDaGrade = new ArrayList<>();

    public Turma(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Turma() {
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

    public List<String> getMateriasDaGrade() {
        return materiasDaGrade;
    }

    public void setMateriasDaGrade(List<String> materiasDaGrade) {
        this.materiasDaGrade = materiasDaGrade;
    }
}
