import model.calendario.SemanaAcademica;
import model.espacos.Grade;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Grade grade = new Grade();
        grade = (Grade) grade.getInfo();

        SemanaAcademica sa = new SemanaAcademica(LocalDate.now(), LocalDate.now());
        sa = (SemanaAcademica) sa.getInfo();
    }
}
