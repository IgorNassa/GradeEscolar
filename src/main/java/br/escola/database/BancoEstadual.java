package br.escola.database;

import br.escola.model.Disciplina;
import br.escola.model.Horario;
import br.escola.model.Professor;

import br.escola.model.*;

import java.util.ArrayList;
import java.util.List;

public class BancoEstadual {
    public static List<Disciplina> disciplinas = new ArrayList<>();
    public static List<Horario> horarios = new ArrayList<>();
    public static List<Professor> professores = new ArrayList<>();
    public static List<Turma> turmas = new ArrayList<>();
    public static List<Aula> gradeGerada = new ArrayList<>();

    // Para gerar IDs automáticos
    public static Long idProf = 1L;
    public static Long idDisc = 1L;
    public static Long idTurma = 1L;
    public static Long idHor = 1L;
}