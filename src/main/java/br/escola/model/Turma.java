package br.escola.model;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Long id;
    private String nome;
    private List<Disciplina> materiasDaGrade = new ArrayList<>();

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

    public List<Disciplina> getMateriasDaGrade() {
        return materiasDaGrade;
    }

    public void setMateriasDaGrade(ArrayList<Disciplina> materiasDaGrade) {
        this.materiasDaGrade = materiasDaGrade;
    }
}
