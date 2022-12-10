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

    public MenuForm() {
        consultarContatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame agendaFrame = new JFrame("AgendaForm");
                agendaFrame.setContentPane(new AgendaForm().panelAgenda);
                agendaFrame.pack();
                agendaFrame.setLocationRelativeTo(null);
                agendaFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });
        consultarGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gradeFrame = new JFrame("GradeForm");
                gradeFrame.setContentPane(new GradeForm().panelGrade);
                gradeFrame.pack();
                gradeFrame.setLocationRelativeTo(null);
                gradeFrame.setVisible(true);
                App.menuFrame.dispose();

            }
        });


        consultarCalendárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame calendarioFrame = new JFrame("CalendariForm");
                calendarioFrame.setContentPane(new CalendarioForm().panelCalendario);
                calendarioFrame.pack();
                calendarioFrame.setLocationRelativeTo(null);
                calendarioFrame.setVisible(true);
                App.menuFrame.dispose();
            }
        });
    }
}
