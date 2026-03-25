package cadastro.repository;

import cadastro.model.Livro;
import cadastro.model.Usuario;
import java.util.List;
import java.util.ArrayList;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario salvar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
        if (usuario.getId() == id) {
            return usuario;
        }
    }
        return null;
    }

    public Usuario buscarPorCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public void atualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() == usuario.getId()){
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    public void deletar(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }
}
