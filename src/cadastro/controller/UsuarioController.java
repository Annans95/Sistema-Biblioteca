package cadastro.controller;

import cadastro.model.Usuario;
import cadastro.service.UsuarioService;

import java.util.Scanner;

public class UsuarioController {

    private UsuarioService usuarioService;
    private Scanner scanner;

    public UsuarioController(UsuarioService usuarioService,
                             Scanner scanner) {
        this.usuarioService = usuarioService;
        this.scanner = scanner;
    }

    public void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);

        usuarioService.cadastrar(usuario);

        System.out.println("Usuário cadastrado!");
    }

    public void listarUsuarios() {
        usuarioService.listarTodos()
                .forEach(System.out::println);
    }
}