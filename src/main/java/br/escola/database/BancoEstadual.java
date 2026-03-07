package br.escola.database;

import br.escola.model.Disciplina;
import br.escola.model.Horario;
import br.escola.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class BancoEstadual {

    public static int idDisc = 1;
    public static int idHorario = 1;
    public static int idProfessor = 1;

    public static List<Disciplina> disciplinas = new ArrayList<>();
    public static List<Horario> horarios = new ArrayList<>();
    public static List<Professor> professores = new ArrayList<>();

}