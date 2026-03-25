package cadastro.service;

import cadastro.model.Usuario;
import cadastro.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {

        Usuario usuario = usuarioRepository.buscarPorId(id);

        if(usuario == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario buscarPorCpf(String cpf) {

        Usuario usuario = usuarioRepository.buscarPorCpf(cpf);

        if(usuario == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);

        if(usuario == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuario;
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.buscarPorNome(nome);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public void alterar(Usuario usuario) {

        Usuario existente = usuarioRepository.buscarPorId(usuario.getId());

        if(existente == null){
            throw new RuntimeException("Usuário não encontrado para atualização");
        }
        usuarioRepository.atualizar(usuario);
    }

    public void remover(int id) {

        Usuario usuario = usuarioRepository.buscarPorId(id);

        if(usuario == null){
            throw new RuntimeException("Usuário não encontrado para remoção");
        }
        usuarioRepository.deletar(id);
    }
}
