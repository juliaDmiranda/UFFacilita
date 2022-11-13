package model.espacos;

import model.BaseData;

public class Disciplina extends BaseData {
    private String professor, nome, horario;
    private Sala sala;

    public Disciplina(String professor, String nome, String horario, Sala sala) {
        this.professor = professor;
        this.nome = nome;
        this.horario = horario;
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "professor='" + professor + '\'' +
                ", nome='" + nome + '\'' +
                ", horario='" + horario + '\'' +
                ", sala=" + sala +
                '}';
    }
}
