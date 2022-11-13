package model.calendario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SemanaAcademica extends Periodo{
    private List<Evento> events;
    
    public SemanaAcademica(String _name, String _description, LocalDate _initialDate, LocalDate _finalDate){
        super(_name, _description, _initialDate, _finalDate);
        events  = new ArrayList<Evento>();
    }
}
