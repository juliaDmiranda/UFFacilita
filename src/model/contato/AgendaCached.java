package model.contato;

import model.BaseData;
import model.ServiceInterface;

import java.util.List;

public class AgendaCached implements ServiceInterface {

    private Agenda agenda;

    public AgendaCached() {
        agenda = (Agenda) getInfo();
    }

    @Override
    public BaseData getInfo() {
        if(agenda == null)
            agenda = new Agenda();
            agenda = (Agenda) agenda.getInfo();

        return agenda;
    }

    public List<Contato> getContatos() {
        return agenda.getContatos();
    }
}
