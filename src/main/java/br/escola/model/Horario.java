package br.escola.model;

public class Horario {
    private Long id;
    private String horaInicio;
    private String horaFim;

    public Horario(Long id, String horaInicio, String horaFim) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}
