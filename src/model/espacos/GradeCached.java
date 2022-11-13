package model.espacos;

import model.BaseData;
import model.ServiceInterface;

public class GradeCached implements ServiceInterface {
    private Grade grade;

    @Override
    public BaseData getInfo() {
        if(grade == null)
            grade = (Grade) grade.getInfo();

        return grade;
    }
}
