package view;

import Utils.UFFacilitaHelpers;
import model.calendario.SemanaAcademica;
import model.espacos.Grade;
import view.forms.AgendaForm;
import view.forms.MenuForm;

import javax.swing.*;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class App {
    public static JFrame menuFrame = new JFrame("MenuForm");

    public static void main(String[] args) throws Exception {
        menuFrame.setContentPane(new MenuForm().panelMenu);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }
}
