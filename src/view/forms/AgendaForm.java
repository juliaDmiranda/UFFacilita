package view.forms;

import controller.contato.AgendaController;
import model.contato.Contato;
import view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgendaForm {
    private JTextField buscaField;
    private JButton buscarButton;
    public JPanel panelAgenda;
    private JButton voltarButton;
    private JPanel contatosPanel;
    private JTable contatosTable;
    private JScrollPane contatosScrollPanel;
    private JLabel appLabel;

    private AgendaController agendaController = new AgendaController();

    public AgendaForm() {
        initView();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.menuFrame.setVisible(true);
                MenuForm.agendaFrame.dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = new DefaultTableModel();
                initTable(modelo);
                List<Contato> contatos = agendaController.getContatosByName(buscaField.getText());
                String[][] dados = formatContatos(contatos);

                contatosTable.setModel(modelo);
                for(String[] contato : dados) {
                    modelo.addRow(contato);
                }
                contatosTable.setAutoCreateRowSorter(true);
            }
        });
    }


    private String[][] formatContatos(List<Contato> contatos) {
        String[][] arrayContatos = new String[contatos.size()][4];

        for(int i = 0; i < contatos.size(); i++) {
            arrayContatos[i] = formatContato(contatos.get(i));
        }

        return (String[][]) arrayContatos;
    }

    private String[] formatContato(Contato contato) {
        return new String[]{contato.getTipo(), contato.getNome(), contato.getEmail(), contato.getTelefone()};
    }

    private void initTable(DefaultTableModel modelo) {
        if(modelo.getColumnCount() == 0) {
            String[] colunas = {"Tipo", "Nome", "Email", "Telefone"};
            for(String coluna : colunas) {
                modelo.addColumn(coluna);
            }
        }
    }

    public void initView()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        initTable(modelo);
        List<Contato> contatos = agendaController.getContatos();
        String[][] dados = formatContatos(contatos);

        contatosTable.setModel(modelo);
        for(String[] contato : dados) {
            modelo.addRow(contato);
        }
        contatosTable.setAutoCreateRowSorter(true);
    }
}
