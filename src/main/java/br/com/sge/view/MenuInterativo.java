package br.com.sge.view;

import br.com.sge.model.dao.*;
import br.com.sge.model.entity.*;
import java.util.*;

public class MenuInterativo {

    private static final Scanner scanner = new Scanner(System.in);

    private static AbstractBaseDAO baseDAO;

    public static void iniciar() {
        while (true){
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1) Gerenciar Alunos");
            System.out.println("2) Gerenciar Cursos");
            System.out.println("3) Gerenciar Professores");
            System.out.println("4) Gerenciar Turmas");
            System.out.println("5) Gerenciar Avaliações");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");

            int opcao = lerInt();

            switch (opcao){
                case 1 -> menuAluno();
                case 2 -> menuCurso();
                case 3 -> menuProfessor();
                case 4 -> menuTurma();
                case 5 -> menuAvaliacao();
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // ------------------------------
    //         SUBMENU ALUNO
    // ------------------------------
    private static void menuAluno(){
        System.out.println("\n===== MENU ALUNO =====");
        System.out.println("1) Criar novo aluno");
        System.out.println("2) Gerar relatório de aluno");
        System.out.println("0) Voltar");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        switch (opcao){
            case 1 -> criarAluno();
            case 2 -> gerarRelatorioAluno();
            case 0 -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void criarAluno(){
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Aluno aluno = new Aluno(nome, null, matricula, new ArrayList<>());
        baseDAO = new AlunoDAO(Aluno.class);
        baseDAO.save(aluno);
        System.out.println("Aluno criado com sucesso!");
        aluno.gerarRelatorio();
    }

    private static void gerarRelatorioAluno(){
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        Aluno aluno = new Aluno(nome, null, "0000", new ArrayList<>());
        aluno.gerarRelatorio();
    }

    // ------------------------------
    //         SUBMENU CURSO
    // ------------------------------
    private static void menuCurso(){
        System.out.println("\n===== MENU CURSO =====");
        System.out.println("1) Criar novo curso");
        System.out.println("2) Detalhar curso");
        System.out.println("0) Voltar");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        switch (opcao){
            case 1 -> criarCurso();
            case 2 -> detalharCurso();
            case 0 -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void criarCurso(){
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Código do curso: ");
        String codigo = scanner.nextLine();

        System.out.print("Carga horária: ");
        int ch = lerInt();

        Curso curso = new Curso(null, nome, codigo, ch, new ArrayList<>());

        baseDAO = new CursoDAO(Curso.class);
        baseDAO.save(curso);

        System.out.println("Curso criado!");
        curso.gerarRelatorio();
    }

    private static void detalharCurso(){
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();

        Curso curso = new Curso(null, nome, "000", 40, new ArrayList<>());
        curso.detalharCurso();
    }

    // ------------------------------
    //       SUBMENU PROFESSOR
    // ------------------------------
    private static void menuProfessor(){
        System.out.println("\n===== MENU PROFESSOR =====");
        System.out.println("1) Criar professor");
        System.out.println("2) Relatório professor");
        System.out.println("0) Voltar");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        switch (opcao){
            case 1 -> criarProfessor();
            case 2 -> gerarRelatorioProfessor();
            case 0 -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void criarProfessor(){
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();

        System.out.print("Especialidade: ");
        String esp = scanner.nextLine();

        System.out.print("Registro: ");
        String reg = scanner.nextLine();

        Professor professor = new Professor(nome, esp, reg);

        baseDAO = new ProfessorDAO(Professor.class);
        baseDAO.save(professor);

        System.out.println("Professor criado!");
        professor.gerarRelatorio();
    }

    private static void gerarRelatorioProfessor(){
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();

        Professor prof = new Professor(nome, "Geral", "12345");
        prof.gerarRelatorio();
    }

    // ------------------------------
    //         SUBMENU TURMA
    // ------------------------------
    private static void menuTurma(){
        System.out.println("\n===== MENU TURMA =====");
        System.out.println("1) Criar turma");
        System.out.println("2) Resumo da turma");
        System.out.println("0) Voltar");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        switch (opcao){
            case 1 -> criarTurma();
            case 2 -> gerarResumoTurma();
            case 0 -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void criarTurma(){
        System.out.print("Código da turma: ");
        String codigo = scanner.nextLine();

        Turma turma = new Turma(null, codigo, new ArrayList<>(), new ArrayList<>());

        baseDAO = new TurmaDAO(Turma.class);
        baseDAO.save(turma);

        System.out.println("Turma criada!");
    }

    private static void gerarResumoTurma(){
        Turma turma = new Turma(null, "A1", new ArrayList<>(), new ArrayList<>());
        turma.geraResumoTurma();
    }

    // ------------------------------
    //       SUBMENU AVALIAÇÃO
    // ------------------------------
    private static void menuAvaliacao(){
        System.out.println("\n===== MENU AVALIAÇÃO =====");
        System.out.println("1) Criar avaliação");
        System.out.println("2) Atribuir nota");
        System.out.println("0) Voltar");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        switch (opcao){
            case 1 -> criarAvaliacao();
            case 2 -> atribuirNota();
            case 0 -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void criarAvaliacao(){
        System.out.print("Descrição da avaliação: ");
        String desc = scanner.nextLine();

        Avaliacao av = new Avaliacao();
        av.setDescricao(desc);

        baseDAO = new AvaliacaoDAO(Avaliacao.class);
        baseDAO.save(av);

        System.out.println("Avaliação criada!");
    }

    private static void atribuirNota(){
        Avaliacao av = new Avaliacao();

        System.out.print("Informe a nota (0 a 10): ");
        int nota = lerInt();

        try {
            av.atribuitNote(nota);
            System.out.println("Nota atribuída!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // ------------------------------
    //     LEITURA SEGURA DE INT
    // ------------------------------
    private static int lerInt() {
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.print("Valor inválido. Digite um número: ");
            }
        }
    }
}
