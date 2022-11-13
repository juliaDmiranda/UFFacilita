package model.calendario;

import model.BaseData;
import model.ServiceInterface;

public class SemanaAcademicaCached implements ServiceInterface {
    private SemanaAcademica semanaAcademica;

    @Override
    public BaseData getInfo() {
        if(semanaAcademica == null)
            semanaAcademica = (SemanaAcademica) semanaAcademica.getInfo();

        return semanaAcademica;
    }
}
