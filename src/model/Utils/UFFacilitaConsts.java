package model.Utils;

public enum UFFacilitaConsts {
    GRADE_JSON_PATH("C:\\RepositoriosFaculdade\\UFFacilita\\src\\data\\grade.json"),
    CALENDARIO_JSON_PATH("C:\\RepositoriosFaculdade\\UFFacilita\\src\\data\\calendarioAcademico.json"),
    SEMANA_JSON_PATH("C:\\RepositoriosFaculdade\\UFFacilita\\src\\data\\semanaAcademica.json"),
    AGENDA_JSON_PATH("C:\\Users\\User\\Desktop\\UFFacilita\\src\\data\\agenda.json")
    ;

    private String value;

    UFFacilitaConsts(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
