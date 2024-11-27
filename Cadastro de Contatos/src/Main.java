import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class CadastroDeContatos {
    private JFrame frame;
    private JTextField nomeField, telefoneField, emailField;
    private JButton adicionarButton, removerButton;
    private JList<String> listaContatos;
    private DefaultListModel<String> listModel;

    public CadastroDeContatos() {
        frame = new JFrame("Cadastro de Contatos");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nomeField = new JTextField(20);
        telefoneField = new JTextField(20);
        emailField = new JTextField(20);

        adicionarButton = new JButton("Adicionar Contato");
        removerButton = new JButton("Remover Contato");

        listModel = new DefaultListModel<>();
        listaContatos = new JList<>(listModel);
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaContatos);
        scrollPane.setPreferredSize(new Dimension(350, 150));

        frame.add(new JLabel("Nome:"));
        frame.add(nomeField);
        frame.add(new JLabel("Telefone:"));
        frame.add(telefoneField);
        frame.add(new JLabel("E-mail:"));
        frame.add(emailField);
        frame.add(adicionarButton);
        frame.add(scrollPane);
        frame.add(removerButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String email = emailField.getText();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                } else {
                    String contato = "Nome: " + nome + " | Telefone: " + telefone + " | E-mail: " + email;
                    listModel.addElement(contato);
                    nomeField.setText("");
                    telefoneField.setText("");
                    emailField.setText("");
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaContatos.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um contato para remover.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CadastroDeContatos();
    }
}
