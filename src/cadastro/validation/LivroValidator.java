package cadastro.validation;

import cadastro.model.Livro;

public class LivroValidator {

    //Métodos de validação
    public boolean idValido(int id) {
        return id > 0;
    }

    public boolean nomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public boolean autorValido(String autor) {
        return autor != null && !autor.trim().isEmpty();
    }

    public boolean edicaoValida(int edicao) {
        return edicao > 0;
    }

    public boolean quantidadeValida(int quantidade) {
        return quantidade >= 0;
    }

    public boolean livroValido(Livro livro) {
        return livro != null &&
                idValido(livro.getId()) &&
                nomeValido(livro.getNome()) &&
                autorValido(livro.getAutor()) &&
                edicaoValida(livro.getEdicao()) &&
                quantidadeValida(livro.getQuantidade());
    }
}
