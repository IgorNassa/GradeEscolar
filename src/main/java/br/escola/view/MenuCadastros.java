package br.escola.view;

import br.escola.database.BancoEstadual;
import br.escola.model.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastros {

    public void cadastrarTurma(Scanner sc){

        System.out.println("Digite o nome da turma:");
        String nomeTurma = sc.nextLine();

        // cria objeto turma
        Turma turma = new Turma();
        turma.setNome(nomeTurma);

        // lista de matérias da grade
        ArrayList<String> materiasDaGrade = new ArrayList<>();

        // loop para adicionar matérias
        while(true){

            System.out.println("Digite o nome de uma matéria para adicionar na grade (ou 'sair' para terminar):");

            String materia = sc.nextLine();

            // se digitar sair, salva turma
            if(materia.equalsIgnoreCase("sair")){

                turma.setMateriasDaGrade(materiasDaGrade);
                BancoEstadual.turmas.add(turma);

                System.out.println("Turma cadastrada com sucesso!");
                break;
            }

            // verifica se disciplina existe
            if(!BancoEstadual.disciplinas.contains(materia)){
                System.out.println("Disciplina não encontrada. Tente novamente.");
                continue;
            }

            // adiciona matéria
            materiasDaGrade.add(materia);
            System.out.println("Matéria adicionada!");

        }

    }

}