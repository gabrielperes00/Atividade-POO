public class ComprovanteResumido implements Comprovante {

    @Override
    public String gerar(Aluno aluno, Curso curso, double valor) {
        return "Matrícula: " + aluno.getNome()
                + " | Curso: " + curso.getTitulo()
                + " | Total: R$ " + String.format("%.2f", valor);
    }
}

