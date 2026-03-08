package br.escola.view;

import br.escola.database.BancoEstadual;

import br.escola.model.Disciplina;
import br.escola.model.Horario;
import br.escola.model.Professor;
import br.escola.model.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastros {
    public  void cadastrarDisciplina(Scanner sc) {
        System.out.println("Digite o nome da Disciplina:");
        String nomeDisciplina = sc.nextLine();
        if (nomeDisciplina.trim().isEmpty()) {/*Aqui o trim remove os espaços e o isEmpty verifica se a String ta vazia*/
            System.out.println("Erro: Por favor digite um nome");
            return;
        }

        Disciplina d = new Disciplina(BancoEstadual.idDisc++, nomeDisciplina);
        BancoEstadual.disciplinas.add(d);

        System.out.println("Disciplina Cadastrada com Sucesso!");
    }

    public void cadastrarHorario(Scanner sc) {

        System.out.println("Digite um horario de inicio:");
        String inicio = sc.nextLine();

        System.out.println("Digite um horario de fim:");
        String fim = sc.nextLine();

        if (inicio.trim().isEmpty() || fim.trim().isEmpty()) {
            System.out.println("Erro: Por favor digite um horario");
            return;
        }

        Horario h = new Horario(BancoEstadual.idHor++, inicio, fim);
        BancoEstadual.horarios.add(h);

        System.out.println("Horário Cadastrado com sucesso!");
    }

    public void cadastrarProfessor(Scanner sc) {

        System.out.println("Digite o nome do Professor:");
        String nome = sc.nextLine();

        if (nome.trim().isEmpty()) {
            System.out.println("Erro: Por favor digite um nome");
            return;
        }

        System.out.println("Disciplinas cadastradas:");

        for (Disciplina d : BancoEstadual.disciplinas) {
            System.out.println("- " + d.getNome());
        }

        System.out.println("Digite a materia dada pelo Professor:");
        String nomeDisciplina = sc.nextLine();

        Disciplina disciplinaEscolhida = null;

        for (Disciplina d : BancoEstadual.disciplinas) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplinaEscolhida = d;
                break;
            }
        }

        if (disciplinaEscolhida == null) {
            System.out.println("Erro: Matéria não encontrada.");
            return;
        }

        Professor p = new Professor(BancoEstadual.idProf++, nome, disciplinaEscolhida);
        BancoEstadual.professores.add(p);

        System.out.println("Professor Cadastrado com sucesso!");
    }

    public void cadastrarTurma(Scanner sc){

        System.out.println("Digite o nome da turma:");
        String nomeTurma = sc.nextLine();

        // cria objeto turma
        Turma turma = new Turma();
        turma.setNome(nomeTurma);

        // lista de matérias da grade
        ArrayList<Disciplina> materiasDaGrade = new ArrayList<>();

        // loop para adicionar matérias
        while(true){

            System.out.println("Digite o nome de uma matéria para adicionar na grade (ou 'sair' para terminar):");

            String materia = sc.nextLine();

            // se digitar sair, salva turma
            if(materia.equalsIgnoreCase("sair")){


                //Tentando cadastrar as materias da turma, porém temos que transformar a entrada em um Objeto Disciplina antes de atr

                turma.setMateriasDaGrade(materiasDaGrade);
                BancoEstadual.turmas.add(turma);

                System.out.println("Turma cadastrada com sucesso!");
                break;
            }

            // verifica se disciplina existe
            Disciplina disciplinaEncontrada = null;

            for (Disciplina d : BancoEstadual.disciplinas) {
                if (d.getNome().equalsIgnoreCase(materia)) {
                    disciplinaEncontrada = d;
                    break;
                }
            }

            if (disciplinaEncontrada == null) {
                System.out.println("Disciplina não encontrada. Tente novamente.");
                continue;
            }

            materiasDaGrade.add(disciplinaEncontrada);
            System.out.println("Matéria adicionada!");
        }
    }

    public void gerarHorariosAutomaticos(Scanner sc) {
        System.out.println("\n--- 🕒 GERADOR AUTOMÁTICO DE TURNOS ---");
        System.out.println("Qual turno a escola vai operar?");
        System.out.println("1 - Matutino (07:30 às 12:00)");
        System.out.println("2 - Vespertino (13:30 às 18:00)");
        System.out.println("3 - Noturno (19:00 às 22:30)");
        System.out.print("Escolha o turno: ");

        int opcaoTurno = Integer.parseInt(sc.nextLine());

        // Limpa a lista caso o usuário já tenha cadastrado algo antes na mão
        BancoEstadual.horarios.clear();
gito
        if (opcaoTurno == 1) {
            BancoEstadual.horarios.add(new Horario(1L, "07:30", "08:20"));
            BancoEstadual.horarios.add(new Horario(2L, "08:20", "09:10"));
            BancoEstadual.horarios.add(new Horario(3L, "09:10", "10:00"));
            // (10:00 as 10:20 seria o Recreio, então pulamos)
            BancoEstadual.horarios.add(new Horario(4L, "10:20", "11:10"));
            BancoEstadual.horarios.add(new Horario(5L, "11:10", "12:00"));
            System.out.println("✅ Turno MATUTINO configurado! (5 aulas criadas)");

        } else if (opcaoTurno == 2) {
            BancoEstadual.horarios.add(new Horario(1L, "13:30", "14:20"));
            BancoEstadual.horarios.add(new Horario(2L, "14:20", "15:10"));
            BancoEstadual.horarios.add(new Horario(3L, "15:10", "16:00"));
            BancoEstadual.horarios.add(new Horario(4L, "16:20", "17:10"));
            BancoEstadual.horarios.add(new Horario(5L, "17:10", "18:00"));
            System.out.println("✅ Turno VESPERTINO configurado! (5 aulas criadas)");

        } else if (opcaoTurno == 3) {
            BancoEstadual.horarios.add(new Horario(1L, "19:00", "19:50"));
            BancoEstadual.horarios.add(new Horario(2L, "19:50", "20:40"));
            BancoEstadual.horarios.add(new Horario(3L, "20:50", "21:40"));
            BancoEstadual.horarios.add(new Horario(4L, "21:40", "22:30"));
            System.out.println("✅ Turno NOTURNO configurado! (4 aulas criadas)");

        } else {
            System.out.println("❌ Opção de turno inválida.");
        }
    }
}