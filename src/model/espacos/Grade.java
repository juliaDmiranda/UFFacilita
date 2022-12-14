package model.espacos;

import model.BaseData;
import model.ServiceInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Utils.UFFacilitaConsts;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Grade extends BaseData {
    String semestreVigente;
    List<Disciplina> disciplinas;

    public Grade() {
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public String getSemestreVigente() {
        return semestreVigente;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public BaseData getInfo() {
        LerArquivo(UFFacilitaConsts.GRADE_JSON_PATH.getValue());
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
                semestreVigente = (String) jsonObject.get("semestre");
                jsonList = (ArrayList<JSONObject>) jsonObject.get("disciplinas");
            }

            if(jsonList != null) {
                for(int i = 0; i < jsonList.size(); i ++) {
                    String professor = (String) jsonList.get(i).get("professor");
                    String nome = (String) jsonList.get(i).get("nome");
                    String horario = (String) jsonList.get(i).get("horario");

                    JSONObject salaObject = (JSONObject) jsonList.get(i).get("sala");
                    int numero = 0;
                    int andar = 0;
                    if(salaObject != null) {
                        numero = salaObject.get("numero") != null ? ((Long)salaObject.get("numero")).intValue() : 0;
                        andar = salaObject.get("andar") != null ? ((Long)salaObject.get("andar")).intValue() : 0;

                    }
                    Sala sala = new Sala(numero, andar);

                    Disciplina d = new Disciplina(professor, nome, horario, sala);
                    disciplinas.add(d);
                }
            }
        }
        //Trata as exceptions que podem ser lan??adas no decorrer do processo
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
