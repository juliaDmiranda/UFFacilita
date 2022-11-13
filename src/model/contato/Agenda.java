package model.contato;
import model.BaseData;
import model.ServiceInterface;

import java.util.ArrayList;
import java.util.List;

import model.Utils.UFFacilitaConsts;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Agenda extends BaseData implements ServiceInterface {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<Contato>();
    }

    @Override
    public BaseData getInfo() {
        LerArquivo(UFFacilitaConsts.AGENDA_JSON_PATH.getValue());
        return this;
    }

    private void LerArquivo(String fileName)
    {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    fileName));

            //Salva nas variaveis os dados retirados do arquivo
            List<JSONObject> jsonList = (ArrayList<JSONObject>) jsonObject.get("contatos");

            contatos = new ArrayList<Contato>();

            for(int i = 0; i < jsonList.size(); i ++) {
                String tipo     = (String) jsonList.get(i).get("tipo");
                String nome     = (String) jsonList.get(i).get("nome");
                String email    = (String) jsonList.get(i).get("email");
                String telefone = (String) jsonList.get(i).get("telefone");

                Contato c = new Contato(tipo, nome, email, telefone);
                contatos.add(c);
            }
            //Trata as exceptions que podem ser lançadas no decorrer do processo
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
