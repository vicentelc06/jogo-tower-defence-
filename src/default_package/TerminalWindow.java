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
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

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

        inputField.addActionListener(e -> {
            try {
                String text = inputField.getText() + "\n";
                outputPipe.write(text.getBytes());
                inputField.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    public InputStream getInputStream() {
        return inputPipe;
    }
}
