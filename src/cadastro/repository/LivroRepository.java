package cadastro.repository;

import cadastro.model.Livro;
import java.util.List;
import java.util.ArrayList;

public class LivroRepository {

    private List<Livro> livros = new ArrayList<>();

    public Livro salvar(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public Livro buscarPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarPorNome(String nome){
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }

    public void atualizar(Livro livro) {
        for (int i = 0; i < livros.size(); i++){
            if (livros.get(i).getId() == livro.getId()){
                livros.set(i, livro);
                return;
            }
        }
    }

    public void deletar(int id) {
        livros.removeIf(l -> l.getId() == id);
    }
}
