package model.calendario;

import model.BaseData;
import model.ServiceInterface;

import java.time.LocalDate;
import java.util.List;

public class SemanaAcademicaCached implements ServiceInterface {
    private SemanaAcademica semanaAcademica;

    public SemanaAcademicaCached() {
        semanaAcademica = (SemanaAcademica) getInfo();
    }

    @Override
    public BaseData getInfo() {
        if(semanaAcademica == null)
            semanaAcademica = new SemanaAcademica();
            semanaAcademica = (SemanaAcademica) semanaAcademica.getInfo();

        return semanaAcademica;
    }

    public Long getAno() {
        return semanaAcademica.getAno();
    }

    public Long getSemestre() {
        return semanaAcademica.getSemestre();
    }

    public LocalDate getInitialDate() {
        return semanaAcademica.getInitialDate();
    }

    public LocalDate getFinalDate() {
        return semanaAcademica.getFinalDate();
    }

    public List<Evento> getEvents() {
        return semanaAcademica.getEvents();
    }
}
