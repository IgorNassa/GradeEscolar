package br.escola.view;

import br.escola.database.BancoEstadual;
import br.escola.model.Disciplina;
import br.escola.model.Horario;
import br.escola.model.Professor;
import br.escola.model.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastros {

    public void cadastrarDisciplina(Scanner sc) {
        System.out.println("--- 📚 CADASTRO DE DISCIPLINA ---");
        System.out.print("Digite o nome da Disciplina: ");
        String nomeDisciplina = sc.nextLine();

        if (nomeDisciplina.trim().isEmpty()) {
            System.out.println("❌ Erro: O nome da disciplina não pode ficar em branco.");
            return;
        }

        Disciplina d = new Disciplina(BancoEstadual.idDisc++, nomeDisciplina.trim());
        BancoEstadual.disciplinas.add(d);

        System.out.println("✅ Disciplina '" + d.getNome() + "' cadastrada com sucesso!");
    }

    public void cadastrarHorario(Scanner sc) {
        System.out.println("--- 📅 CADASTRO DE HORÁRIO (MANUAL) ---");
        System.out.print("Digite o horário de INÍCIO (ex: 07:30): ");
        String inicio = sc.nextLine();

        System.out.print("Digite o horário de FIM (ex: 08:20): ");
        String fim = sc.nextLine();

        if (inicio.trim().isEmpty() || fim.trim().isEmpty()) {
            System.out.println("❌ Erro: Os horários não podem ficar em branco.");
            return;
        }

        Horario h = new Horario(BancoEstadual.idHor++, inicio.trim(), fim.trim());
        BancoEstadual.horarios.add(h);

        System.out.println("✅ Horário " + inicio + " às " + fim + " cadastrado com sucesso!");
    }

    public void cadastrarProfessor(Scanner sc) {
        System.out.println("--- 👨‍🏫 CADASTRO DE PROFESSOR ---");

        if (BancoEstadual.disciplinas.isEmpty()) {
            System.out.println("⚠️ Erro: Nenhuma disciplina cadastrada! Cadastre uma disciplina primeiro.");
            return;
        }

        System.out.print("Digite o nome do Professor: ");
        String nome = sc.nextLine();

        if (nome.trim().isEmpty()) {
            System.out.println("❌ Erro: O nome não pode ficar em branco.");
            return;
        }

        System.out.println("\nDisciplinas disponíveis no sistema:");
        for (Disciplina d : BancoEstadual.disciplinas) {
            System.out.println(" - " + d.getNome());
        }

        System.out.print("\nDigite exatamente a matéria lecionada por este professor: ");
        String nomeDisciplina = sc.nextLine().trim();

        Disciplina disciplinaEscolhida = null;
        for (Disciplina d : BancoEstadual.disciplinas) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplinaEscolhida = d;
                break;
            }
        }

        if (disciplinaEscolhida == null) {
            System.out.println("❌ Erro: Matéria '" + nomeDisciplina + "' não encontrada no sistema.");
            return;
        }

        Professor p = new Professor(BancoEstadual.idProf++, nome, disciplinaEscolhida);
        BancoEstadual.professores.add(p);

        System.out.println("✅ Professor " + nome + " (" + disciplinaEscolhida.getNome() + ") cadastrado com sucesso!");
    }

    public void cadastrarTurma(Scanner sc) {
        System.out.println("--- 🏫 CADASTRO DE TURMA ---");
        System.out.print("Digite o nome da turma (ex: 1º Ano A): ");
        String nomeTurma = sc.nextLine();

        if (nomeTurma.trim().isEmpty()) {
            System.out.println("❌ Erro: O nome da turma não pode ficar em branco.");
            return;
        }

        Turma turma = new Turma();
        turma.setNome(nomeTurma.trim());
        ArrayList<Disciplina> materiasDaGrade = new ArrayList<>();

        System.out.println("\nVamos montar a grade da turma " + nomeTurma + "!");
        System.out.println("Dica: Digite as matérias já cadastradas no sistema.");

        while (true) {
            System.out.print("Digite o nome da matéria (ou 'sair' para finalizar): ");
            String materia = sc.nextLine().trim();

            if (materia.equalsIgnoreCase("sair")) {
                if (materiasDaGrade.isEmpty()) {
                    System.out.println("⚠️ Aviso: Você está salvando uma turma sem nenhuma matéria!");
                }
                turma.setMateriasDaGrade(materiasDaGrade);
                BancoEstadual.turmas.add(turma);
                System.out.println("✅ Turma '" + nomeTurma + "' salva com sucesso!");
                break;
            }

            Disciplina disciplinaEncontrada = null;
            for (Disciplina d : BancoEstadual.disciplinas) {
                if (d.getNome().equalsIgnoreCase(materia)) {
                    disciplinaEncontrada = d;
                    break;
                }
            }

            if (disciplinaEncontrada == null) {
                System.out.println("❌ Disciplina não encontrada. Verifique o nome e tente novamente.");
                continue;
            }

            materiasDaGrade.add(disciplinaEncontrada);
            System.out.println("✔️ Matéria '" + disciplinaEncontrada.getNome() + "' adicionada à grade do " + nomeTurma + "!");
        }
    }

    public void gerarHorariosAutomaticos(Scanner sc) {
        System.out.println("--- 🕒 CONFIGURADOR AUTOMÁTICO DE TURNOS ---");
        System.out.println("Qual turno a escola vai operar?");
        System.out.println("[ 1 ] Matutino (07:30 às 12:00)");
        System.out.println("[ 2 ] Vespertino (13:30 às 18:00)");
        System.out.println("[ 3 ] Noturno (19:00 às 22:30)");
        System.out.print("Escolha o turno: ");

        try {
            int opcaoTurno = Integer.parseInt(sc.nextLine());

            BancoEstadual.horarios.clear();

            if (opcaoTurno == 1) {
                BancoEstadual.horarios.add(new Horario(1L, "07:30", "08:20"));
                BancoEstadual.horarios.add(new Horario(2L, "08:20", "09:10"));
                BancoEstadual.horarios.add(new Horario(3L, "09:10", "10:00"));
                BancoEstadual.horarios.add(new Horario(4L, "10:20", "11:10"));
                BancoEstadual.horarios.add(new Horario(5L, "11:10", "12:00"));
                System.out.println("✅ Turno MATUTINO configurado! (5 aulas base criadas)");

            } else if (opcaoTurno == 2) {
                BancoEstadual.horarios.add(new Horario(1L, "13:30", "14:20"));
                BancoEstadual.horarios.add(new Horario(2L, "14:20", "15:10"));
                BancoEstadual.horarios.add(new Horario(3L, "15:10", "16:00"));
                BancoEstadual.horarios.add(new Horario(4L, "16:20", "17:10"));
                BancoEstadual.horarios.add(new Horario(5L, "17:10", "18:00"));
                System.out.println("✅ Turno VESPERTINO configurado! (5 aulas base criadas)");

            } else if (opcaoTurno == 3) {
                BancoEstadual.horarios.add(new Horario(1L, "19:00", "19:50"));
                BancoEstadual.horarios.add(new Horario(2L, "19:50", "20:40"));
                BancoEstadual.horarios.add(new Horario(3L, "20:50", "21:40"));
                BancoEstadual.horarios.add(new Horario(4L, "21:40", "22:30"));
                System.out.println("✅ Turno NOTURNO configurado! (4 aulas base criadas)");

            } else {
                System.out.println("❌ Opção de turno inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ ERRO: Por favor, digite apenas o número do turno.");
        }
    }
}