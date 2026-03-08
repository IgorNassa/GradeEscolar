package br.escola;

import br.escola.view.MenuCadastros;
import java.util.Scanner;
import br.escola.core.GeradorForcaBruta;
import br.escola.database.BancoEstadual;
import br.escola.model.*;
import br.escola.model.Aula;

public class Main {
    public static void main(String[] args) {

        popularBanco();
        Scanner sc = new Scanner(System.in);
        MenuCadastros menuCadastros = new MenuCadastros();

        while (true) {

            System.out.println("1-Cadastrar Prof \n 2-Turma \n 3-Horário \n 4-Disciplina \n 5-Gerar Grade \n 6- Ver grade gerada");
            try {
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastro de professor ainda não implementado.");
                        break;

                    case 2:
                        menuCadastros.gerarHorariosAutomaticos(sc);
                        break;

                    case 3:
                        System.out.println("Cadastro de horário ainda não implementado.");
                        break;

                    case 4:
                        System.out.println("Cadastro de disciplina ainda não implementado.");
                        break;

                    case 5:
                        GeradorForcaBruta gerador = new GeradorForcaBruta();
                        gerador.gerarGrade();
                        verGrade();
                        break;

                    case 6:
                        verGrade();
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("ERRO: Por favor, digite apenas números inteiros válidos!");
            }
        }
    }

    public static void popularBanco() {
        // DISCIPLINAS
        BancoEstadual.disciplinas.add(new Disciplina(1L, "Matematica"));
        BancoEstadual.disciplinas.add(new Disciplina(2L, "Portugues"));
        BancoEstadual.disciplinas.add(new Disciplina(3L, "Geografia"));

        // HORARIOS
        BancoEstadual.horarios.add(new Horario(1L, "07:30", "08:20"));
        BancoEstadual.horarios.add(new Horario(2L, "08:20", "09:10"));
        BancoEstadual.horarios.add(new Horario(3L, "09:10", "10:00"));

        // PROFESSORES
        BancoEstadual.professores.add(new Professor(1L, "Pedro", BancoEstadual.disciplinas.get(0)));
        BancoEstadual.professores.add(new Professor(2L, "Alan", BancoEstadual.disciplinas.get(1)));
        BancoEstadual.professores.add(new Professor(3L, "Felipe", BancoEstadual.disciplinas.get(2)));

        // TURMAS (Com as matérias inseridas na lista interna!)
        Turma turma1 = new Turma(1L, "1° Ano A");
        turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(0));;
        turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(1));
        turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(2));

        BancoEstadual.turmas.add(turma1);

        System.out.println("🌱 Banco populado com sucesso!");
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