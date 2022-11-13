package model.contato;

import model.BaseData;
import model.ServiceInterface;

public class AgendaCached implements ServiceInterface {

    private Agenda agenda;

    @Override
    public BaseData getInfo() {
        if(agenda == null)
            agenda = (Agenda) agenda.getInfo();

        return agenda;
    }
}
