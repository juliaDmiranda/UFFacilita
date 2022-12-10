package view.forms;

import view.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaForm {
    private JTextField textField1;
    private JButton button1;
    public JPanel panelAgenda;
    private JButton voltarButton;

    public AgendaForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.menuFrame.setVisible(true);
                MenuForm.agendaFrame.dispose();
            }
        });
    }
}
