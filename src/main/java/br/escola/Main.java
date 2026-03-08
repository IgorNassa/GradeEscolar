package br.escola;


import br.escola.database.BancoEstadual;
import br.escola.model.Aula;

public class Main {

    public static void main(String[] args) {

        popularBanco();

        public static void popularBanco () {
            System.out.println("populando banco de dados");

            //DISCIPLINAS
            BancoEstadual.disciplinas.add(new Disciplina(1, "Matematica"));
            BancoEstadual.disciplinas.add(new Disciplina(2, "Portugues"));
            BancoEstadual.disciplinas.add(new Disciplina(3, "Geografia"));

            //HORARIOS

            BancoEstadual.horarios.add(new Horario(1, "07:30", "08:20"));
            BancoEstadual.horarios.add(new Horario(1, "08:20", "09:10"));
            BancoEstadual.horarios.add(new Horario(1, "09:10", "10:00"));

            //PROFESSORES

            BancoEstadual.professores.add(new Professor(1, "Pedro", "Matematica"));
            BancoEstadual.professores.add(new Professor(1, "Alan", "Portugues"));
            BancoEstadual.professores.add(new Professor(1, "Felipe", "Geografia"));

            //TURMAS
            BancoEstadual.turmas.add(new Turma(1, "1º Ano A"));

            System.out.println("Banco populado com sucesso");

        }

        //task 10
        //impressao da grade
        public static void verGrade ()
        {
            System.out.println("\n================= GRADE ESCOLAR =================");

            if (BancoEstadual.gradeGerada.isEmpty()) {
                System.out.println("Nenhuma grade foi encontrada.");
                return;
            }

            // Cabeçalho
            System.out.printf("%-15s %-10s %-15s %-15s\n", "TURMA", "HORÁRIO", "DISCIPLINA", "PROFESSOR");
            System.out.println("-------------------------------------------------------------");

            for (Aula a : BancoEstadual.gradeGerada) {
                System.out.printf(
                        "%-15s %-10s %-15s %-15s\n",
                        a.getTurmaNome(),
                        a.getHorarioInicio(),
                        a.getMateria(),
                        a.getProfNome()
                );
            }

            System.out.println("=============================================================");
        }
    }
}
