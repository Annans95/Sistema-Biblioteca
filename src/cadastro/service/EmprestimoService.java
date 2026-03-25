package cadastro.service;

import cadastro.model.Emprestimo;
import cadastro.model.Livro;
import cadastro.model.Usuario;
import cadastro.repository.EmprestimoRepository;
import cadastro.repository.UsuarioRepository;
import cadastro.repository.LivroRepository;
import java.time.LocalDate;

import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    public EmprestimoService() {
        this.emprestimoRepository = new EmprestimoRepository();
        this.usuarioRepository = new UsuarioRepository();
        this.livroRepository = new LivroRepository();
    }

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             UsuarioRepository usuarioRepository,
                             LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {

        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        if(usuario == null){
            throw new RuntimeException("Usuário não existe");
        }
        Livro livro = livroRepository.buscarPorId(livroId);
        if(livro == null){
            throw new RuntimeException("Livro não existe");
        }
        if (diasEmprestimo <= 0) {
            throw new RuntimeException("Dias de empréstimo inválidos");
        }

        boolean livroJaEmprestado = emprestimoRepository.listarTodos()
                .stream()
                .anyMatch(e -> e.getLivroId() == livroId && e.isAtivo());

        if (livroJaEmprestado) {
            throw new RuntimeException("Não é possível emprestar: livro já está emprestado");
        }

        LocalDate hoje = LocalDate.now();
        LocalDate dataDevolucao = hoje.plusDays(diasEmprestimo);

        Emprestimo emprestimo = new Emprestimo(
                proximoId++,
                usuarioId,
                livroId,
                hoje,
                dataDevolucao
        );

        return emprestimoRepository.salvar(emprestimo);
    }

    public void devolverLivro(int emprestimoId) {

        Emprestimo emprestimo = emprestimoRepository.buscarPorId(emprestimoId);

        if (emprestimo == null) {
            throw new RuntimeException("Empréstimo não encontrado");
        }

        if (!emprestimo.isAtivo()) {
            throw new RuntimeException("Empréstimo já foi finalizado");
        }

        Livro livro = livroRepository.buscarPorId(emprestimo.getLivroId());

        if (livro == null) {
            throw new RuntimeException("Livro do empréstimo não encontrado");
        }

        emprestimo.setAtivo(false);
        emprestimo.setDataDevoluçaoReal(LocalDate.now());
    }

    public List<Emprestimo> buscarEmprestimosDoUsuario(int usuarioId) {
        return emprestimoRepository.listarTodos()
                .stream()
                .filter(e -> e.getUsuarioId() == usuarioId)
                .toList();
    }

    public List<Emprestimo> buscarEmprestimosAtivosDoUsuario(int usuarioId) {
        return emprestimoRepository.listarTodos()
                .stream()
                .filter(e -> e.getUsuarioId() == usuarioId && e.isAtivo())
                .toList();
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.listarTodos();
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimoRepository.listarTodos()
                .stream()
                .filter(Emprestimo::isAtivo)
                .toList();
    }

    public Emprestimo buscarPorId(int id) {

        Emprestimo emprestimo = emprestimoRepository.buscarPorId(id);

        if(emprestimo == null){
            throw new RuntimeException("Empréstimo não encontrado");
        }
        return emprestimo;
    }

    public boolean verificarAtraso(int emprestimoId) {

        Emprestimo emprestimo = emprestimoRepository.buscarPorId(emprestimoId);

        if(emprestimo == null){
            throw new RuntimeException("Empréstimo não encontrado");
        }
        return LocalDate.now().isAfter(emprestimo.getDataDevolucaoPrevista());
    }
}
