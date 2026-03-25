package cadastro.validation;

import cadastro.model.Emprestimo;

import java.time.LocalDate;

public class EmprestimoValidator {

    public boolean idValido(int id) {
        return id > 0;
    }

    public boolean usuarioIdValido(int usuarioId) {
        return usuarioId > 0;
    }

    public boolean livroIdValido(int livroId) {
        return livroId > 0;
    }

    public boolean dataValida(LocalDate data) {
        return data != null;
    }

    public boolean datasValidas(Emprestimo e) {
        return e.getDataEmprestimo() != null &&
                e.getDataDevolucaoPrevista() != null &&
                !e.getDataDevolucaoPrevista().isBefore(e.getDataEmprestimo());
    }

    public boolean emprestimoValido(Emprestimo e) {
        return e != null &&
                idValido(e.getId()) &&
                usuarioIdValido(e.getUsuarioId()) &&
                livroIdValido(e.getLivroId()) &&
                datasValidas(e);
    }
}
