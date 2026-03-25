package cadastro.validation;

import cadastro.model.Usuario;

public class UsuarioValidator {

    public boolean idValido(int id) {
        return id > 0;
    }

    public boolean nomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public boolean emailValido(String email) {
        return email != null &&
                email.contains("@") &&
                email.contains(".");
    }

    public boolean cpfValido(String cpf) {
        return cpf != null &&
                cpf.length() == 11;
    }

    public boolean telefoneValido(String telefone) {
        return telefone != null &&
                !telefone.trim().isEmpty();
    }

    public boolean usuarioValido(Usuario usuario) {
        return usuario != null &&
                idValido(usuario.getId()) &&
                nomeValido(usuario.getNome()) &&
                emailValido(usuario.getEmail()) &&
                cpfValido(usuario.getCpf()) &&
                telefoneValido(usuario.getTelefone());
    }
}