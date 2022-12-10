package controller.calendario;

import model.calendario.CalendarioAcademicoCached;
import model.calendario.Periodo;

import java.util.ArrayList;
import java.util.List;

public class CalendarioAcademicoController {
    private CalendarioAcademicoCached calendarioAcademicoCached;

    public CalendarioAcademicoController() {
        calendarioAcademicoCached = new CalendarioAcademicoCached();
    }

    public List<Periodo> getDataByName(String name) {
        ArrayList<Periodo> datas = (ArrayList<Periodo>) calendarioAcademicoCached.getDatas();

        ArrayList<Periodo> datasNome = new ArrayList<Periodo>();
        for(Periodo p : datas) {
            if(p.getName().toLowerCase().contains(name.toLowerCase()))
                datasNome.add(p);
        }
        return datasNome;
    }

    public List<Periodo> getDatas() {
        return calendarioAcademicoCached.getDatas();
    }
}
