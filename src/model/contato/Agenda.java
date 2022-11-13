package model.contato;
import model.BaseData;
import model.ServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class Agenda extends BaseData implements ServiceInterface {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<Contato>();
    }


    @Override
    public BaseData getInfo() {
        return null;
    }
}
