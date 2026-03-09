package br.escola;

import br.escola.view.MenuCadastros;
import java.util.Scanner;
import br.escola.core.GeradorForcaBruta;
import br.escola.database.BancoEstadual;
import br.escola.model.*;

public class Main {
    public static void main(String[] args) {

        popularBanco();
        Scanner sc = new Scanner(System.in);
        MenuCadastros menuCadastros = new MenuCadastros();

        while (true) {
            limparTela();
            System.out.println("========================================");
            System.out.println("       🏫 SISTEMA GRID GENERATOR        ");
            System.out.println("========================================");
            System.out.println(" [ 1 ] 👨‍🏫 Cadastrar Professor");
            System.out.println(" [ 2 ] 🕒 Configurar Turnos (Automático)");
            System.out.println(" [ 3 ] 📅 Cadastrar Horário (Manual)");
            System.out.println(" [ 4 ] 📚 Cadastrar Disciplina");
            System.out.println(" [ 5 ] 🏫 Cadastrar Turma e Grade");
            System.out.println(" [ 6 ] ⚙️  GERAR GRADE AUTOMÁTICA");
            System.out.println(" [ 7 ] 📊 Ver Grade Gerada");
            System.out.println(" [ 0 ] ❌ Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        limparTela();
                        menuCadastros.cadastrarProfessor(sc);
                        pausar(sc);
                        break;

                    case 2:
                        limparTela();
                        menuCadastros.gerarHorariosAutomaticos(sc);
                        pausar(sc);
                        break;

                    case 3:
                        limparTela();
                        menuCadastros.cadastrarHorario(sc);
                        pausar(sc);
                        break;

                    case 4:
                        limparTela();
                        menuCadastros.cadastrarDisciplina(sc);
                        pausar(sc);
                        break;

                    case 5:
                        limparTela();
                        menuCadastros.cadastrarTurma(sc);
                        pausar(sc);
                        break;

                    case 6:
                        limparTela();
                        GeradorForcaBruta gerador = new GeradorForcaBruta();
                        gerador.gerarGrade();
                        verGrade();
                        pausar(sc);
                        break;

                    case 7:
                        limparTela();
                        verGrade();
                        pausar(sc);
                        break;

                    case 0:
                        System.out.println("👋 Saindo do sistema... Até logo!");
                        sc.close();
                        return;

                    default:
                        System.out.println("⚠️ Opção inválida! Escolha um número do menu.");
                        pausar(sc);
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("\n❌ ERRO: Por favor, digite apenas números inteiros válidos!");
                pausar(sc);
            } catch (Exception e) {
                System.out.println("\n❌ ERRO INESPERADO: Ocorreu um problema no sistema. Tente novamente.");
                pausar(sc);
            }
        }
    }

    // ==========================================
    // MÉTODOS DE UTILIDADE E UX (Limpar e Pausar)
    // ==========================================

    public static void limparTela() {
        // Tenta limpar usando código ANSI (Funciona em terminais modernos)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // Fallback: Imprime várias linhas em branco para simular limpeza em IDEs (IntelliJ/Eclipse)
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void pausar(Scanner sc) {
        System.out.println("\n(Pressione [ENTER] para voltar ao menu principal...)");
        sc.nextLine();
    }

    // ==========================================
    // MÉTODOS DE BANCO E IMPRESSÃO
    // ==========================================

    public static void popularBanco() {
        try {
            BancoEstadual.disciplinas.add(new Disciplina(1L, "Matematica"));
            BancoEstadual.disciplinas.add(new Disciplina(2L, "Portugues"));
            BancoEstadual.disciplinas.add(new Disciplina(3L, "Geografia"));

            BancoEstadual.horarios.add(new Horario(1L, "07:30", "08:20"));
            BancoEstadual.horarios.add(new Horario(2L, "08:20", "09:10"));
            BancoEstadual.horarios.add(new Horario(3L, "09:10", "10:00"));

            BancoEstadual.professores.add(new Professor(1L, "Pedro", BancoEstadual.disciplinas.get(0)));
            BancoEstadual.professores.add(new Professor(2L, "Alan", BancoEstadual.disciplinas.get(1)));
            BancoEstadual.professores.add(new Professor(3L, "Felipe", BancoEstadual.disciplinas.get(2)));

            Turma turma1 = new Turma(1L, "1° Ano A");
            turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(0));
            turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(1));
            turma1.getMateriasDaGrade().add(BancoEstadual.disciplinas.get(2));

            BancoEstadual.turmas.add(turma1);
            System.out.println("🌱 Banco populado com sucesso!");
        } catch (Exception e) {
            System.out.println("⚠️ Aviso: Erro ao popular dados de teste.");
        }
    }

    public static void verGrade() {
        System.out.println("\n=========================== GRADE ESCOLAR ===========================");
        if (BancoEstadual.gradeGerada.isEmpty()) {
            System.out.println("⚠️ Nenhuma grade foi gerada ainda. Use a opção 6 primeiro.");
            System.out.println("=====================================================================");
            return;
        }
        System.out.printf("%-15s %-10s %-15s %-15s\n", "TURMA", "HORÁRIO", "DISCIPLINA", "PROFESSOR");
        System.out.println("---------------------------------------------------------------------");
        for (Aula a : BancoEstadual.gradeGerada) {
            System.out.printf(
                    "%-15s %-10s %-15s %-15s\n",
                    a.getTurmaNome(),
                    a.getHorarioInicio(),
                    a.getMateria(),
                    a.getProfNome()
            );
        }
        System.out.println("=====================================================================");
    }
}