
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Estudante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();
        JLabel turmaLabel = new JLabel("Turma:");
        JTextField turmaField = new JTextField();
        JLabel[] notasLabels = new JLabel[4];
        JTextField[] notasFields = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            notasLabels[i] = new JLabel("Nota " + (i + 1) + ":");
            notasFields[i] = new JTextField();
        }
        JButton calcularButton = new JButton("Calcular Média");

        JLabel resultLabel = new JLabel();
        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(cpfLabel);
        frame.add(cpfField);
        frame.add(turmaLabel);
        frame.add(turmaField);
        for (int i = 0; i < 4; i++) {
            frame.add(notasLabels[i]);
            frame.add(notasFields[i]);
        }
        frame.add(calcularButton);
        frame.add(resultLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String cpf = cpfField.getText();
                String turma = turmaField.getText();
                float[] notas = new float[4];
                for (int i = 0; i < 4; i++) {
                    notas[i] = Float.parseFloat(notasFields[i].getText());
                }

                metodos estudante = new metodos(nome, cpf, turma, notas);
                float media = estudante.calcularMedia();
                String situacao = estudante.getSituacao();

                resultLabel.setText("<html>Nome: " + estudante.getNome() +
                                    "<br>CPF: " + estudante.getCpf() +
                                    "<br>Turma: " + estudante.getTurma() +
                                    "<br>Média: " + media +
                                    "<br>Situação: " + situacao + "</html>");
            }
        });

        frame.setVisible(true);
    }

}
