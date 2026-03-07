package br.escola;

import br.escola.view.MenuCadastros;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuCadastros menu = new MenuCadastros();

        menu.cadastrarDisciplina(sc);
        menu.cadastrarHorario(sc);
        menu.cadastrarProfessor(sc);

    }
}