package controller.espacos;

import model.espacos.Disciplina;
import model.espacos.GradeCached;

import java.util.ArrayList;
import java.util.List;

public class GradeController {
    public GradeCached gradeCached;

    public List<Disciplina> getDisciplinasByName(String name) {
        ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) gradeCached.getDisciplinas();

        List<Disciplina> disciplinasNome = new ArrayList<Disciplina>();
        for(Disciplina d : disciplinas) {
            if(d.getNome().toLowerCase().contains(name.toLowerCase()))
                disciplinasNome.add(d);
        }
        return disciplinas;
    }

    public List<Disciplina> getDisciplinasByProfessor(String professor) {
        ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) gradeCached.getDisciplinas();

        List<Disciplina> disciplinasProf = new ArrayList<Disciplina>();
        for(Disciplina d : disciplinas) {
            if(d.getProfessor().toLowerCase().contains(professor.toLowerCase()))
                disciplinasProf.add(d);
        }
        return disciplinasProf;
    }
    public List<Disciplina> getDisciplinas() {
        return gradeCached.getDisciplinas();
    }
}
