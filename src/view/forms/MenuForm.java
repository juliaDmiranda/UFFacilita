package view.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

public class MenuForm {
    public JPanel panelMenu;
    private JButton consultarContatosButton;
    private JButton consultarSemanaAcadêmicaButton;
    private JButton consultarGradeButton;
    private JButton consultarCalendárioButton;
    private JLabel logoICT;
    private JLabel logoApp;

    public static JFrame calendarioFrame;
    public static JFrame semanaAcademicaFrame;
    public static JFrame gradeFrame;
    public static JFrame agendaFrame;

    public MenuForm() {
        consultarContatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(agendaFrame == null) {
                    agendaFrame = new JFrame("AgendaForm");
                    agendaFrame.setContentPane(new AgendaForm().panelAgenda);
                    agendaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    agendaFrame.pack();
                    agendaFrame.setLocationRelativeTo(null);
                }
                agendaFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });
        consultarGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(agendaFrame == null) {
                    gradeFrame = new JFrame("GradeForm");
                    gradeFrame.setContentPane(new GradeForm().panelGrade);
                    gradeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gradeFrame.pack();
                    gradeFrame.setLocationRelativeTo(null);
                }
                gradeFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });


        consultarCalendárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(calendarioFrame == null)
                {
                    calendarioFrame = new JFrame("CalendarioForm");
                    calendarioFrame.setContentPane(new CalendarioForm().panelCalendario);
                    calendarioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    calendarioFrame.pack();
                    calendarioFrame.setLocationRelativeTo(null);
                }
                calendarioFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });
        consultarSemanaAcadêmicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(semanaAcademicaFrame == null) {
                    semanaAcademicaFrame = new JFrame("SemanaAcademicaForm");
                    semanaAcademicaFrame.setContentPane(new SemanaAcademicaForm().panelSemanaAcademica);
                    semanaAcademicaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    semanaAcademicaFrame.pack();
                    semanaAcademicaFrame.setLocationRelativeTo(null);
                }
                semanaAcademicaFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });
    }
}
