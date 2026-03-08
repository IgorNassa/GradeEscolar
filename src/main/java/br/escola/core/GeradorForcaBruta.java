package br.escola.core;

import br.escola.database.BancoEstadual;
import br.escola.model.*;

public class GeradorForcaBruta {

    public void gerarGrade() {

        System.out.println("⏳ Iniciando o Gerador de Grade (Força Bruta)...");

        BancoEstadual.gradeGerada.clear();

        for (Turma turma : BancoEstadual.turmas) {
            for (Disciplina materiaDesejada : turma.getMateriasDaGrade()) {

                Professor professorEncontrado = null;
                for (Professor prof : BancoEstadual.professores) {
                    if (prof.getDisciplinaLecionada() ==  materiaDesejada) {
                        professorEncontrado = prof;
                        break;
                    }
                }

                if (professorEncontrado == null) {
                    System.out.println("⚠️ ALERTA: Sem professor para a matéria " + materiaDesejada + " na turma " + turma.getNome());
                    continue;
                }

                boolean aulaAlocada = false;

                for (Horario horario : BancoEstadual.horarios) {

                    boolean professorOcupado = false;
                    for (Aula aulaGerada : BancoEstadual.gradeGerada) {
                        if (aulaGerada.getProfNome().equals(professorEncontrado.getNome()) &&
                                aulaGerada.getHorarioInicio().equals(horario.getHoraInicio())) {
                            professorOcupado = true;
                            break;
                        }
                    }

                    if (!professorOcupado) {
                        Aula novaAula = new Aula(
                                turma.getNome(),
                                professorEncontrado.getNome(),
                                materiaDesejada.getNome(),
                                horario.getHoraInicio()
                        );

                        BancoEstadual.gradeGerada.add(novaAula);
                        aulaAlocada = true;
                        break;
                    }
                }

                if (!aulaAlocada) {
                    System.out.println("⚠️ ALERTA: Não achou horário livre para " + professorEncontrado.getNome() + " dar " + materiaDesejada);
                }
            }
        }

        System.out.println("✅ Geração concluída! Verifique o menu de Impressão de Grade.");
    }
}