package br.escola.model;

public class Aula {

    private String turmaNome;
    private String profNome;
    private String materia;
    private String horarioInicio;

    public Aula(String turmaNome, String profNome, String materia, String horarioInicio) {
        this.turmaNome = turmaNome;
        this.profNome = profNome;
        this.materia = materia;
        this.horarioInicio = horarioInicio;
    }

    public String getTurmaNome() { return turmaNome; }
    public String getProfNome() { return profNome; }
    public String getMateria() { return materia; }
    public String getHorarioInicio() { return horarioInicio; }
}