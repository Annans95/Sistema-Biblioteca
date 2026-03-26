package cadastro.exception;

public class LivroJaCadastradoException extends RuntimeException {
    public LivroJaCadastradoException(){
        super("Já existe um livro cadastrado com esse nome");
    }

}
