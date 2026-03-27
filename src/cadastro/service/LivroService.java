package cadastro.service;

import cadastro.exception.LivroJaCadastradoException;
import cadastro.model.Livro;
import cadastro.repository.LivroRepository;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {

        List<Livro> existentes = livroRepository.buscarPorNome(livro.getNome());

        if(!existentes.isEmpty()) {
            throw new LivroJaCadastradoException();
        }
        Livro livroSalvo = livroRepository.salvar(livro);
      
        System.out.println("Livro '" + livroSalvo.getNome() + "' cadastrado com sucesso no sistema.");

        return livroSalvo;
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