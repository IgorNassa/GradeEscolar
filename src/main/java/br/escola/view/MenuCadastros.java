package br.escola.view;

import br.escola.database.BancoEstadual;
import br.escola.model.Disciplina;
import br.escola.model.Horario;
import br.escola.model.Professor;

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

        Horario h = new Horario(BancoEstadual.idHorario++, inicio, fim);
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

        Professor p = new Professor(BancoEstadual.idProfessor++, nome, disciplinaEscolhida);
        BancoEstadual.professores.add(p);

        System.out.println("Professor Cadastrado com sucesso!");
    }
}

