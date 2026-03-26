package cadastro.service;

import cadastro.model.Livro;
import cadastro.repository.LivroRepository;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        this.livroRepository = new LivroRepository();
    }
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public String cadastrar(Livro livro) {
        livroRepository.salvar(livro);
        return "Livro cadastrado com sucesso";
    }

    public Livro buscarPorId(int id) {
        Livro livro = livroRepository.buscarPorId(id);

        if (livro == null) {
            throw new RuntimeException("Livro não encontrado");
        }
        return livro;
    }

    public List<Livro> buscarPorNome(String nome) {
        return livroRepository.buscarPorNome(nome);
    }

    public List<Livro> listarTodos() {
        return livroRepository.listarTodos();
    }

    public void alterar(Livro livro) {
        Livro existe = livroRepository.buscarPorId(livro.getId());

        if(existe == null) {
            throw new RuntimeException("Livro não encontrado para atualização");
        }
        livroRepository.atualizar(livro);
    }

    public void remover(int id) {
        Livro livro = livroRepository.buscarPorId(id);

        if(livro == null){
            throw new RuntimeException("Livro não encontrado para remoção");
        }
        livroRepository.deletar(id);
    }

}
