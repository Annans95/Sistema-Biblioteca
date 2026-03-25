package cadastro.service;

import cadastro.model.Livro;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        this.livroRepository = new LivroRepository();
    }

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        return null;
    }

    public Livro buscarPorId(int id) {
        return null;
    }

    public List<Livro> buscarPorNome(String nome) {
        return null;
    }

    public List<Livro> listarTodos() {
        return null;
    }

    public void alterar(Livro livro) {
    }

    public void remover(int id) {
    }
}
