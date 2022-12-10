package controller.calendario;
import model.calendario.Evento;
import model.calendario.SemanaAcademicaCached;
import model.contato.Contato;

import java.util.ArrayList;
import java.util.List;

public class SemanaAcademicaController{
    public SemanaAcademicaCached semanaAcademicaCached;

    public SemanaAcademicaController() {
        semanaAcademicaCached = new SemanaAcademicaCached();
    }

    public List<Evento> getEventoByName(String name) {
        ArrayList<Evento> eventos = (ArrayList<Evento>) semanaAcademicaCached.getEvents();

        ArrayList<Evento> eventosNome = new ArrayList<Evento>();
        for(Evento e : eventos) {
            if(e.getName().toLowerCase().contains(name.toLowerCase()))
                eventosNome.add(e);
        }
        return eventosNome;
    }

    public List<Evento> getEventos() {
        return semanaAcademicaCached.getEvents();
    }
}
