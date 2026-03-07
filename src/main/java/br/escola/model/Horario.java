package br.escola.model;

public class Horario {

    private int id;
    private String inicio;
    private String fim;

    public Horario(int id, String inicio, String fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }
    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }
}