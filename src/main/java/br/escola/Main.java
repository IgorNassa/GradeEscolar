package br.escola;
<<<<<<< HEAD
import br.escola.core.GeradorForcaBruta;
import br.escola.database.BancoEstadual;
import br.escola.model.*;

import java.util.Scanner;

import br.escola.view.MenuCadastros;
=======
import br.escola.database.BancoEstadual;
import br.escola.model.Aula;

import java.util.Scanner;

import br.escola.database.BancoEstadual;
import br.escola.model.Aula;
>>>>>>> 2f612ee53ab2917677874e99bb72333be69552eb

public class Main {
    public static void main(String[] args) {

        popularBanco();
        Scanner sc = new Scanner(System.in);
        MenuCadastros menuCadastros = new MenuCadastros();

        while (true) {
<<<<<<< HEAD
            System.out.println("1-Cadastrar Prof \n 2-Turma \n 3-Horário \n 4-Disciplina \n 5-Gerar Grade \n 6- Ver grade gerada");
=======
            System.out.println("1-Cadastrar Prof | 2-Turma | 3-Horário | 4-Disciplina | 5-Gerar Grade");
>>>>>>> 2f612ee53ab2917677874e99bb72333be69552eb

            try {
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastro de professor ainda não implementado.");
                        break;

                    case 2:
<<<<<<< HEAD
                        menuCadastros.gerarHorariosAutomaticos(sc);
=======
                        menuCadastros.cadastrarTurma(sc);
>>>>>>> 2f612ee53ab2917677874e99bb72333be69552eb
                        break;

                    case 3:
                        System.out.println("Cadastro de horário ainda não implementado.");
                        break;

                    case 4:
                        System.out.println("Cadastro de disciplina ainda não implementado.");
                        break;

                    case 5:
<<<<<<< HEAD
                        GeradorForcaBruta gerador = new GeradorForcaBruta();
                        gerador.gerarGrade();
                        verGrade();
                        break;

                    case 6:
                        verGrade();
=======
                        System.out.println("Geração de grade ainda não implementada.");
>>>>>>> 2f612ee53ab2917677874e99bb72333be69552eb
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
<<<<<<< HEAD
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
        BancoEstadual.professores.add(new Professor(1L, "Pedro", "Matematica"));
        BancoEstadual.professores.add(new Professor(2L, "Alan", "Portugues"));
        BancoEstadual.professores.add(new Professor(3L, "Felipe", "Geografia"));

        // TURMAS (Com as matérias inseridas na lista interna!)
        Turma turma1 = new Turma(1L, "1° Ano A");
        turma1.getMateriasDaGrade().add("Matematica");
        turma1.getMateriasDaGrade().add("Portugues");
        turma1.getMateriasDaGrade().add("Geografia");

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
=======

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
>>>>>>> 2f612ee53ab2917677874e99bb72333be69552eb
    }
}