package Utils;

public enum UFFacilitaConsts {
    GRADE_JSON_PATH(System.getProperty("user.dir") + "/src/data/grade.json"),
    CALENDARIO_JSON_PATH(System.getProperty("user.dir") + "/src/data/calendarioAcademico.json"),
    SEMANA_JSON_PATH(System.getProperty("user.dir") + "/src/data/semanaAcademica.json"),
    AGENDA_JSON_PATH(System.getProperty("user.dir") + "/src/data/agenda.json")
    ;

    private String value;

    UFFacilitaConsts(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
