package cadastro.repository;

import cadastro.model.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Emprestimo salvar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public Emprestimo buscarPorId(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == id) {
                return emprestimo;
            }
        }
        return null;
    }

    public List<Emprestimo> buscarPorUsuario(int usuarioId) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuarioId() == usuarioId) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    public List<Emprestimo> buscarEmprestimosAtivos(int usuarioId) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuarioId() == usuarioId && emprestimo.isAtivo()) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()) {
                ativos.add(emprestimo);
            }
        }
        return ativos;
    }

    public void atualizar(Emprestimo emprestimo) {
        for (int i = 0; i < emprestimos.size(); i++){
            if (emprestimos.get(i).getId() == emprestimo.getId()){
                emprestimos.set(i, emprestimo);
                return;
            }
        }

    }

    public void deletar(int id) {
        emprestimos.removeIf(e -> e.getId() == id);
    }
}
