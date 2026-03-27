package cadastro.controller;

import cadastro.model.Livro;
import cadastro.service.LivroService;
import cadastro.service.EmprestimoService;

import java.util.Scanner;

public class LivroController {

    private LivroService livroService;
    private EmprestimoService emprestimoService;
    private Scanner scanner;

    public LivroController(LivroService livroService,
                           EmprestimoService emprestimoService,
                           Scanner scanner) {
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
        this.scanner = scanner;
    }

    public void cadastrarLivro() {

        System.out.print("Nome do livro: ");
        String nome = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Quantidade: ");
        String quantidade = scanner.nextLine();

        System.out.print("Edição: ");
        String edicao = scanner.nextLine();

        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setQuantidade(Integer.parseInt(quantidade));
        livro.setEdicao(Integer.parseInt(edicao));

        livroService.cadastrar(livro);

        System.out.println("Livro cadastrado!");
    }

    public void listarLivros() {
        livroService.listarTodos()
                .forEach(System.out::println);
    }

    public void emprestarLivro() {
        System.out.print("ID do usuário: ");
        int usuarioId = scanner.nextInt();

        System.out.print("ID do livro: ");
        int livroId = scanner.nextInt();

        System.out.print("Dias de empréstimo: ");
        int dias = scanner.nextInt();
        scanner.nextLine();

        emprestimoService.realizarEmprestimo(usuarioId, livroId, dias);

        System.out.println("Empréstimo realizado!");
    }

    public void devolverLivro() {
        System.out.print("ID do empréstimo: ");
        int emprestimoId = scanner.nextInt();
        scanner.nextLine();

        emprestimoService.devolverLivro(emprestimoId);

        System.out.println("Livro devolvido!");
    }
}
