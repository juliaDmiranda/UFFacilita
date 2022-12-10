package controller.contato;

import model.contato.AgendaCached;
import model.contato.Contato;
import model.espacos.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    public AgendaCached agendaCached;

    public AgendaController() {
        agendaCached = new AgendaCached();
    }

    public List<Contato> getContatosByName(String name) {
        ArrayList<Contato> contatos = (ArrayList<Contato>) agendaCached.getContatos();

        ArrayList<Contato> contatosNome = new ArrayList<Contato>();
        for(Contato c : contatos) {
            if(c.getNome().toLowerCase().contains(name.toLowerCase()))
                contatosNome.add(c);
        }
        return contatosNome;
    }

    public List<Contato> getContatos() {
        return agendaCached.getContatos();
    }
}
