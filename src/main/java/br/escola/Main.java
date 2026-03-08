package br.escola;

import br.escola.view.MenuCadastros;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuCadastros menuCadastros = new MenuCadastros();

        while (true) {
            System.out.println("1-Cadastrar Prof | 2-Turma | 3-Horário | 4-Disciplina | 5-Gerar Grade");

            try {
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastro de professor ainda não implementado.");
                        break;

                    case 2:
                        menuCadastros.cadastrarTurma(sc);
                        break;

                    case 3:
                        System.out.println("Cadastro de horário ainda não implementado.");
                        break;

                    case 4:
                        System.out.println("Cadastro de disciplina ainda não implementado.");
                        break;

                    case 5:
                        System.out.println("Geração de grade ainda não implementada.");
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
}