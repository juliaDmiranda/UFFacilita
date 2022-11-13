package model.calendario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Evento {
    String name, description;
    LocalDate date;
    LocalTime time;
    List<String> hosts;
    
    public Evento(){}

    public Evento(String _name, String _description, LocalDate _date, LocalTime _time, List<String> _hosts){
        name        = _name;
        description = _description;
        date        = _date;
        time        = _time;
        hosts       = _hosts;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getHosts() {
        return hosts;
    }
    public String getName() {
        return name;
    }
    public LocalTime getTime() {
        return time;
    }
}
