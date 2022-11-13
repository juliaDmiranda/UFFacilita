package model.calendario;

import model.BaseData;
import model.ServiceInterface;

public class CalendarioAcademicoCached implements ServiceInterface {

    private CalendarioAcademico calendarioAcademico;


    @Override
    public BaseData getInfo() {
        if(calendarioAcademico == null)
            calendarioAcademico = (CalendarioAcademico) calendarioAcademico.getInfo();

        return calendarioAcademico;
    }
}
