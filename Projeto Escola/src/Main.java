import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class AplicativoDeNotas {
    private JFrame frame;
    private JTextField notaField;
    private JTextArea notasArea;
    private ArrayList<Double> notas;
    private JButton adicionarNotaButton, calcularMediaButton;
    private JLabel mediaLabel;

    public AplicativoDeNotas() {
        notas = new ArrayList<>();
        frame = new JFrame("Aplicativo de Notas");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        notaField = new JTextField(10);
        adicionarNotaButton = new JButton("Adicionar Nota");
        calcularMediaButton = new JButton("Calcular Média");
        notasArea = new JTextArea(10, 30);
        notasArea.setEditable(false);
        mediaLabel = new JLabel("Média: -");

        frame.add(new JLabel("Digite a nota:"));
        frame.add(notaField);
        frame.add(adicionarNotaButton);
        frame.add(new JScrollPane(notasArea));
        frame.add(calcularMediaButton);
        frame.add(mediaLabel);

        adicionarNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(notaField.getText());
                    notas.add(nota);
                    notasArea.append("Nota: " + nota + "\n");
                    notaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido.");
                }
            }
        });

        calcularMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Adicione pelo menos uma nota.");
                } else {
                    double soma = 0;
                    for (double nota : notas) {
                        soma += nota;
                    }
                    double media = soma / notas.size();
                    String status = media >= 7.0 ? "Aprovado" : "Reprovado";
                    mediaLabel.setText("Média: " + media + " - Status: " + status);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AplicativoDeNotas();
    }
}
