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
import java.util.ArrayList;
import java.util.List;

public class CalendarioAcademico extends BaseData implements ServiceInterface {
    private int ano, semestre;
    private List<Periodo> datas;

    public CalendarioAcademico() {
        this.datas    = new ArrayList<Periodo>();
    }

    public int getAno() {
        return ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public List<Periodo> getDatas() {
        return datas;
    }

    @Override
    public BaseData getInfo() {
        LerArquivo(UFFacilitaConsts.CALENDARIO_JSON_PATH.getValue());

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
                ano = jsonObject.get("ano") != null ? ((Long)jsonObject.get("ano")).intValue() : 0;
                semestre = jsonObject.get("semestre") != null ? ((Long)jsonObject.get("semestre")).intValue() : 0;
                jsonList = (ArrayList<JSONObject>) jsonObject.get("datas");
            }

            datas = new ArrayList<Periodo>();

            if(jsonList != null) {
                for(int i = 0; i < jsonList.size(); i ++) {
                    String nome = (String) jsonList.get(i).get("nome");
                    String descricao = (String) jsonList.get(i).get("descricao");
                    LocalDate dataInicio = LocalDate.parse((String) jsonList.get(i).get("dataInicio"));
                    LocalDate dataTermino = LocalDate.parse((String) jsonList.get(i).get("dataTermino"));


                    Periodo p = new Periodo(nome, descricao, dataInicio, dataTermino);
                    datas.add(p);
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
