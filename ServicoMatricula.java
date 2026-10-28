import java.util.ArrayList;
import java.util.List;

public class ServicoMatricula {

    private final Desconto desconto;
    private final RegistradorPagamento pagamento;
    private final List<ObservadorMatricula> observadores =
            new ArrayList<>();

    public ServicoMatricula(
            Desconto desconto,
            RegistradorPagamento pagamento) {
        this.desconto = desconto;
        this.pagamento = pagamento;
    }

    public void inscrever(ObservadorMatricula observador) {
        observadores.add(observador);
    }

    public double matricular(Aluno aluno, Curso curso) {

        // 1. Aplicar a política de desconto
        double total = desconto.aplicar(curso.getPreco());

        // 2. Registrar o pagamento usando o adaptador
        pagamento.registrar(total);

        // 3. Associar o curso ao aluno
        aluno.adicionarCurso(curso);

        // 4. Notificar todos os observadores
        String mensagem = aluno.getNome()
                + " matriculado em "
                + curso.getTitulo();

        for (ObservadorMatricula observador : observadores) {
            observador.atualizar(mensagem);
        }

        // 5. Retornar o valor final com desconto
        return total;
    }
}

