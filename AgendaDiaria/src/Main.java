import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class AgendaDiaria {
    private JFrame frame;
    private JTextField compromissoField;
    private JSpinner dataSpinner;
    private JButton adicionarButton, removerButton;
    private JTable tabelaCompromissos;
    private DefaultTableModel tableModel;

    public AgendaDiaria() {
        frame = new JFrame("Agenda Diária");
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compromissoField = new JTextField(20);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dataSpinner = new JSpinner(dateModel);
        adicionarButton = new JButton("Adicionar Compromisso");
        removerButton = new JButton("Remover Compromisso");

        String[] columnNames = {"Data/Hora", "Compromisso"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tabelaCompromissos = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(tabelaCompromissos);
        tableScroll.setPreferredSize(new Dimension(450, 150));

        frame.add(new JLabel("Compromisso:"));
        frame.add(compromissoField);
        frame.add(new JLabel("Data/Hora:"));
        frame.add(dataSpinner);
        frame.add(adicionarButton);
        frame.add(tableScroll);
        frame.add(removerButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = compromissoField.getText();
                Date dataHora = (Date) dataSpinner.getValue();
                if (compromisso.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira o compromisso.");
                } else {
                    Object[] row = {dataHora, compromisso};
                    tableModel.addRow(row);
                    compromissoField.setText("");
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaCompromissos.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um compromisso para remover.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AgendaDiaria();
    }
}
