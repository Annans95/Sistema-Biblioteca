package cadastro.application;

import cadastro.controller.LivroController;
import cadastro.controller.UsuarioController;
import cadastro.service.LivroService;
import cadastro.service.UsuarioService;
import cadastro.service.EmprestimoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");

        Scanner scanner = new Scanner(System.in);

        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        EmprestimoService emprestimoService = new EmprestimoService();

        LivroController livroController =
                new LivroController(livroService, emprestimoService, scanner);

        UsuarioController usuarioController =
                new UsuarioController(usuarioService, scanner);

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Listar Usuários");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    livroController.cadastrarLivro();
                    break;
                case 2:
                    usuarioController.cadastrarUsuario();
                    break;
                case 3:
                    livroController.emprestarLivro();
                    break;
                case 4:
                    livroController.devolverLivro();
                    break;
                case 5:
                    livroController.listarLivros();
                    break;
                case 6:
                    usuarioController.listarUsuarios();
                    break;
            }

        } while (opcao != 0);
    }
}