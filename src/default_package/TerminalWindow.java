package default_package;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TerminalWindow extends JFrame {
    private JTextArea textArea;
    private JTextField inputField;

    private PipedOutputStream outputPipe;
    private PipedInputStream inputPipe;

    public TerminalWindow() {
        setTitle("Tower Defense - interface joguinho");
        setSize(650, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(240, 240, 240));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(240, 240, 240));

        inputField = new JTextField();
        inputField.setFont(new Font("Consolas", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));

        JButton enviarBtn = new JButton("Enviar");
        enviarBtn.setFocusPainted(false);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(enviarBtn, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        });
        System.setOut(printStream);
        System.setErr(printStream);

        try {
            outputPipe = new PipedOutputStream();
            inputPipe = new PipedInputStream(outputPipe);
        } catch (IOException e) {
            e.printStackTrace();
        }

        inputField.addActionListener(e -> enviarTexto());

        enviarBtn.addActionListener(e -> enviarTexto());

        setVisible(true);
    }

    private void enviarTexto() {
        try {
            String text = inputField.getText() + "\n";
            outputPipe.write(text.getBytes());
            inputField.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return inputPipe;
    }
}
