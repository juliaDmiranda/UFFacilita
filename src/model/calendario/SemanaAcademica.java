package model.calendario;
import model.BaseData;
import model.ServiceInterface;
import Utils.UFFacilitaConsts;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SemanaAcademica extends BaseData implements ServiceInterface {
    private Long ano, semestre;
    private LocalDate initialDate, finalDate;
    private List<Evento> events;
    
    public SemanaAcademica(LocalDate _initialDate, LocalDate _finalDate){
        initialDate = _initialDate;
        finalDate =  _finalDate;
        events  = new ArrayList<Evento>();
    }

    public Long getAno() {
        return ano;
    }

    public Long getSemestre() {
        return semestre;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public List<Evento> getEvents() {
        return events;
    }

    @Override
    public BaseData getInfo() {
        LerArquivo(UFFacilitaConsts.SEMANA_JSON_PATH.getValue());
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

            List<JSONObject> jsonList = new ArrayList<>();

            if(jsonObject != null) {
                //Salva nas variaveis os dados retirados do arquivo
                ano = jsonObject.get("ano") != null ? (Long) jsonObject.get("ano") : 0;
                semestre = jsonObject.get("semestre") != null ? (Long) jsonObject.get("semestre") : 0;
                initialDate = LocalDate.parse((String) jsonObject.get("dataInicio"));
                finalDate = LocalDate.parse((String) jsonObject.get("dataTermino"));
                jsonList = (ArrayList<JSONObject>) jsonObject.get("events");
            }

            events = new ArrayList<Evento>();

            if(jsonList != null) {
                for(int i = 0; i < jsonList.size(); i ++) {
                    String nome = (String) jsonList.get(i).get("nome");
                    String descricao = (String) jsonList.get(i).get("descricao");
                    LocalDate data = LocalDate.parse((String) jsonList.get(i).get("data"));
                    LocalTime time = LocalTime.parse((String) jsonList.get(i).get("time"));
                    List<String> hosts = (List<String>) jsonList.get(i).get("hosts");

                    Evento e = new Evento(nome, descricao, data, time, hosts);
                    events.add(e);
                }
            }
        }
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
