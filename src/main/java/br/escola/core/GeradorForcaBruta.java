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
                            break;
                        }
                    }

                    // 6. VALIDAÇÃO DE CHOQUE DUPLO: Professor ocupado OU Turma ocupada neste horário?
                    boolean temConflito = false;
                    for (Aula aulaGerada : BancoEstadual.gradeGerada) {

                        // Choque 1: O professor já tá dando aula em outra turma nessa hora?
                        if (aulaGerada.getProfNome().equals(professorEncontrado.getNome()) &&
                                aulaGerada.getHorarioInicio().equals(horario.getHoraInicio())) {
                            temConflito = true;
                            break;
                        }

                        // Choque 2: A turma já tem alguma outra matéria alocada nessa exata hora?
                        if (aulaGerada.getTurmaNome().equals(turma.getNome()) &&
                                aulaGerada.getHorarioInicio().equals(horario.getHoraInicio())) {
                            temConflito = true;
                            break;
                        }
                    }

                    // 7. Se não tem conflito nem de professor, nem de turma, cria a Aula e salva!
                    if (!temConflito) {
                        Aula novaAula = new Aula(
                                turma.getNome(),
                                professorEncontrado.getNome(),
                                materiaDesejada.getNome(),
                                horario.getHoraInicio()
                        );

                        BancoEstadual.gradeGerada.add(novaAula);
                        aulaAlocada = true;

                        // Aula marcada com sucesso. Para o loop de horários e vai pra próxima matéria.
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