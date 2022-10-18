package model.entity.espacos;

public class Disciplina {
    private String professor, nome, horario;
    private Sala sala;

    public Disciplina(String professor, String nome, String horario, Sala sala) {
        this.professor = professor;
        this.nome = nome;
        this.horario = horario;
        this.sala = sala;
    }
}
