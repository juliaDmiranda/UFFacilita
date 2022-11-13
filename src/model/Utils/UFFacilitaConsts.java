package model.Utils;

public enum UFFacilitaConsts {
    GRADE_JSON_PATH("C:\\RepositoriosFaculdade\\UFFacilita\\src\\data\\grade.json"),
    ;

    private String value;

    UFFacilitaConsts(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
