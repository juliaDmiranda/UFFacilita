package model.calendario;

import model.BaseData;
import model.ServiceInterface;

import java.util.List;

public class CalendarioAcademicoCached implements ServiceInterface {

    private CalendarioAcademico calendarioAcademico;


    @Override
    public BaseData getInfo() {
        if(calendarioAcademico == null)
            calendarioAcademico = (CalendarioAcademico) calendarioAcademico.getInfo();

        return calendarioAcademico;
    }

    public int getAno() {
        return calendarioAcademico.getAno();
    }

    public int getSemestre() {
        return calendarioAcademico.getSemestre();
    }

    public List<Periodo> getDatas() {
        return calendarioAcademico.getDatas();
    }
}
