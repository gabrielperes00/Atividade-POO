public class ComprovanteTexto implements Comprovante {

    @Override
    public String gerar(Aluno aluno, Curso curso, double valor) {
        return "=== COMPROVANTE DE MATRÍCULA ===\n"
                + "Aluno: " + aluno.getNome() + "\n"
                + "Curso: " + curso.getTitulo() + "\n"
                + "Valor pago: R$ " + String.format("%.2f", valor);
    }
}
