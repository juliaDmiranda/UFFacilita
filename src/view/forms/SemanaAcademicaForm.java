package view.forms;

import controller.calendario.SemanaAcademicaController;
import model.calendario.Evento;
import model.calendario.Periodo;
import view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SemanaAcademicaForm {
    public JPanel panelSemanaAcademica;
    private JPanel panelAuxiliar;
    private JButton buscarButton;
    private JPanel semanaPanel;
    private JScrollPane semanaScrollPanel;
    private JTable semanaTable;
    private JButton voltarButton;
    private JLabel appLabel;
    private JTextField buscaField;

    private SemanaAcademicaController semanaAcademicaController = new SemanaAcademicaController();

    public SemanaAcademicaForm() {
        initView();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.menuFrame.setVisible(true);
                MenuForm.semanaAcademicaFrame.dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = new DefaultTableModel();
                initTable(modelo);
                List<Evento> eventos = semanaAcademicaController.getEventoByName(buscaField.getText());
                String[][] dados = formatEventos(eventos);

                semanaTable.setModel(modelo);
                for(String[] evento : dados) {
                    modelo.addRow(evento);
                }
                semanaTable.setAutoCreateRowSorter(true);
            }
        });
    }

    private void initTable(DefaultTableModel modelo) {
        if(modelo.getColumnCount() == 0) {
            String[] colunas = {"Nome", "Descrição", "Data", "Horário", "Palestrantes"};
            for(String coluna : colunas) {
                modelo.addColumn(coluna);
            }
        }
    }

    private String[][] formatEventos(List<Evento> eventos) {
        String[][] arrayEventos = new String[eventos.size()][5];

        for(int i = 0; i < eventos.size(); i++) {
            arrayEventos[i] = formatEvento(eventos.get(i));
        }

        return (String[][]) arrayEventos;
    }

    private String[] formatEvento(Evento evento) {
        String hosts = "";
        for(String h : evento.getHosts()) {
            hosts += h + ", ";
        }
        hosts = hosts.substring(0, hosts.length() - 2);
        return new String[]{evento.getName(), evento.getDescription(), evento.getDate().toString(), evento.getTime(), hosts};
    }

    public void initView()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        initTable(modelo);
        List<Evento> eventos = semanaAcademicaController.getEventos();
        String[][] dados = formatEventos(eventos);

        semanaTable.setModel(modelo);
        for(String[] evento : dados) {
            modelo.addRow(evento);
        }
        semanaTable.setAutoCreateRowSorter(true);
    }
}
