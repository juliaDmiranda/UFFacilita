import model.espacos.Grade;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) throws Exception {
        Grade grade = new Grade();
        grade = (Grade) grade.getInfo();
    }
}
