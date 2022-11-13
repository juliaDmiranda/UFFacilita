package model.espacos;

import model.BaseData;
import model.ServiceInterface;

import java.util.List;

public class Grade extends BaseData implements ServiceInterface {
    String semestreVigente;
    List<Disciplina> disciplinas;

    @Override
    public BaseData getInfo() {
        return null;
    }
}
