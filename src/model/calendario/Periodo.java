package model.calendario;

import java.time.LocalDate;

public class Periodo {
    protected String name, description;
    protected LocalDate initialDate, finalDate;

    protected Periodo(String _name, String _description, LocalDate _initialDate, LocalDate _finalDate){
        name        = _name;
        description = _description;
        initialDate = _initialDate;
        finalDate   = _finalDate;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getFinalDate() {
        return finalDate;
    }
    public LocalDate getInitialDate() {
        return initialDate;
    }
    public String getName() {
        return name;
    }

}
