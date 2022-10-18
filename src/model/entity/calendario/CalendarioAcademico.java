package model.entity.calendario;

import java.util.ArrayList;
import java.util.List;

public class CalendarioAcademico {
    private int ano, semestre;
    private List<Periodo> datas;

    public CalendarioAcademico(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.datas    = new ArrayList<Periodo>();
    }

    
}
