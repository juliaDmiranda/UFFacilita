package model.calendario;

import model.BaseData;
import model.ServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class CalendarioAcademico extends BaseData implements ServiceInterface {
    private int ano, semestre;
    private List<Periodo> datas;

    public CalendarioAcademico(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.datas    = new ArrayList<Periodo>();
    }


    @Override
    public BaseData getInfo() {
        // Lê arquivo e preenche valores
        return null;
    }
}
