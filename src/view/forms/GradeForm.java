package view.forms;

import controller.espacos.GradeController;
import model.espacos.Disciplina;
import model.espacos.Sala;
import view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GradeForm {
    public JPanel panelGrade;
    private JPanel panelAuxiliar;
    private JButton buscarButton;
    private JPanel gradePanel;
    private JScrollPane gradeScrollPanel;
    private JTable gradeTable;
    private JButton voltarButton;
    private JLabel appLabel;
    private JTextField buscaField;

    private GradeController gradeController = new GradeController();

    public GradeForm() {
        initView();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.menuFrame.setVisible(true);
                MenuForm.gradeFrame.dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = new DefaultTableModel();
                initTable(modelo);
                List<Disciplina> disciplinas = gradeController.getDisciplinasByName(buscaField.getText());
                String[][] dados = formatDisciplinas(disciplinas);

                gradeTable.setModel(modelo);
                for(String[] disciplina : dados) {
                    modelo.addRow(disciplina);
                }
                gradeTable.setAutoCreateRowSorter(true);
            }
        });
    }

    private void initTable(DefaultTableModel modelo) {
        if(modelo.getColumnCount() == 0) {
            String[] colunas = {"Nome", "Professor", "Horário", "Sala", "Andar"};
            for(String coluna : colunas) {
                modelo.addColumn(coluna);
            }
        }
    }

    private String[][] formatDisciplinas(List<Disciplina> disciplinas) {
        String[][] arrayDisciplinas = new String[disciplinas.size()][5];

        for(int i = 0; i < disciplinas.size(); i++) {
            arrayDisciplinas[i] = formatDisciplina(disciplinas.get(i));
        }

        return (String[][]) arrayDisciplinas;
    }

    private String[] formatDisciplina(Disciplina disciplina) {
        Sala sala = disciplina.getSala();
        return new String[]{disciplina.getNome(), disciplina.getProfessor(),
                disciplina.getHorario(), String.valueOf(sala.getNumero()), String.valueOf(sala.getAndar())};
    }

    public void initView()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        initTable(modelo);
        List<Disciplina> disciplinas = gradeController.getDisciplinas();
        String[][] dados = formatDisciplinas(disciplinas);

        gradeTable.setModel(modelo);
        for(String[] disciplina : dados) {
            modelo.addRow(disciplina);
        }
        gradeTable.setAutoCreateRowSorter(true);
    }
}
