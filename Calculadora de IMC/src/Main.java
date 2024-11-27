import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculadoraIMC {
    private JFrame frame;
    private JTextField pesoField, alturaField;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public CalculadoraIMC() {
        frame = new JFrame("Calculadora de IMC");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pesoField = new JTextField(10);
        alturaField = new JTextField(10);
        calcularButton = new JButton("Calcular IMC");
        resultadoLabel = new JLabel("Resultado: ");

        frame.add(new JLabel("Peso (kg):"));
        frame.add(pesoField);
        frame.add(new JLabel("Altura (m):"));
        frame.add(alturaField);
        frame.add(calcularButton);
        frame.add(resultadoLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(pesoField.getText());
                    double altura = Double.parseDouble(alturaField.getText());
                    if (peso <= 0 || altura <= 0) {
                        JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.");
                        return;
                    }
                    double imc = peso / (altura * altura);
                    String categoria = "";
                    if (imc < 18.5) {
                        categoria = "Baixo peso";
                    } else if (imc < 24.9) {
                        categoria = "Normal";
                    } else if (imc < 29.9) {
                        categoria = "Sobrepeso";
                    } else {
                        categoria = "Obesidade";
                    }
                    resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, categoria));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraIMC();
    }
}
