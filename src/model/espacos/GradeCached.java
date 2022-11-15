package model.espacos;

import model.BaseData;
import model.ServiceInterface;

import java.util.List;

public class GradeCached implements ServiceInterface {
    private Grade grade;

    @Override
    public BaseData getInfo() {
        if(grade == null)
            grade = (Grade) grade.getInfo();

        return grade;
    }

    public String getSemestreVigente() {
        return grade.getSemestreVigente();
    }

    public List<Disciplina> getDisciplinas() {
        return grade.getDisciplinas();
    }
}
