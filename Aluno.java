import java.util.ArrayList;

public class Aluno {

    private final String nome;
    private final ArrayList<Curso> cursos;

    public Aluno(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso inválido");
        }

        cursos.add(curso);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeCursos() {
        return cursos.size();
    }
}
