package view.forms;

import controller.calendario.CalendarioAcademicoController;
import model.calendario.CalendarioAcademico;
import model.calendario.Periodo;
import model.contato.Contato;
import view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalendarioForm {
    public JPanel panelCalendario;
    private JPanel calendarioPanel;
    private JScrollPane calendarioScrollPanel;
    private JTable calendarioTable;
    private JButton voltarButton;
    private JButton buscarButton;
    private JTextField buscaField;
    private JLabel appLabel;

    private CalendarioAcademicoController calendarioAcademicoController = new CalendarioAcademicoController();

    public CalendarioForm() {
        initView();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.menuFrame.setVisible(true);
                MenuForm.calendarioFrame.dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = new DefaultTableModel();
                initTable(modelo);
                List<Periodo> periodos = calendarioAcademicoController.getDataByName(buscaField.getText());
                String[][] dados = formatPeriodos(periodos);

                calendarioTable.setModel(modelo);
                for(String[] periodo : dados) {
                    modelo.addRow(periodo);
                }
                calendarioTable.setAutoCreateRowSorter(true);
            }
        });
    }

    private void initTable(DefaultTableModel modelo) {
        if(modelo.getColumnCount() == 0) {
            String[] colunas = {"Nome", "Descrição", "Início", "Término"};
            for(String coluna : colunas) {
                modelo.addColumn(coluna);
            }
        }
    }

    private String[][] formatPeriodos(List<Periodo> periodos) {
        String[][] arrayPeriodos = new String[periodos.size()][4];

        for(int i = 0; i < periodos.size(); i++) {
            arrayPeriodos[i] = formatPeriodo(periodos.get(i));
        }

        return (String[][]) arrayPeriodos;
    }

    private String[] formatPeriodo(Periodo periodo) {
        return new String[]{periodo.getName(), periodo.getDescription(), periodo.getInitialDate().toString(), periodo.getFinalDate().toString()};
    }

    public void initView()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        initTable(modelo);
        List<Periodo> periodos = calendarioAcademicoController.getDatas();
        String[][] dados = formatPeriodos(periodos);

        calendarioTable.setModel(modelo);
        for(String[] periodo : dados) {
            modelo.addRow(periodo);
        }
        calendarioTable.setAutoCreateRowSorter(true);
    }
}
