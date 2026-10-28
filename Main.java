
public class Main {

    public static void main(String[] args) {

        // 1. Singleton: obter a configuração do sistema
        System.out.println(
            Configuracao.getInstancia().getNome()
        );

        // 2. Criar o aluno e o curso
        Aluno aluno = new Aluno("Ana");
        Curso curso = new Curso("Java", 200.00);

        // 3. Strategy + Adapter: configurar desconto e pagamento
        Desconto desconto = new DescontoEstudante();

        SistemaLegado legado = new SistemaLegado();
        RegistradorPagamento pagamento =
            new AdaptadorPagamento(legado);

        // 4. Criar o serviço de matrícula
        ServicoMatricula servico =
            new ServicoMatricula(desconto, pagamento);

        // 5. Observer: inscrever os observadores
        servico.inscrever(new AvisoEmail());
        servico.inscrever(new Auditoria());

        // 6. Factory Method + Facade
        CriadorComprovante criador = new CriadorTexto();

        FachadaAcademica fachada =
            new FachadaAcademica(servico, criador);

        // 7. Realizar matrícula e emitir comprovante
        String comprovante =
            fachada.matricularEEmitir(aluno, curso);

        System.out.println(comprovante);

        // 8. Verificar a quantidade de cursos
        System.out.println(
            "Cursos do aluno: " + aluno.getQuantidadeCursos()
        );
    }
}