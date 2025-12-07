package default_package;

import javax.swing.*;

public class MainInterface {
    public static void main(String[] args) {
        // Carrega sprites
        SpriteLoader.loadDefaultSprites();

        // cria engine
        GameEngine engine = new GameEngine();

        SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow(engine);

            // Timer: 1 segundo por tick
            new Timer(1000, e -> {

                engine.tick();               // lógica do jogo
                window.getGrid().repaint();  // redesenha GridPanel

                if (engine.isGameOver()) {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(window, "Você perdeu!");
                } else if (engine.hasWon()) {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(window, "Você ganhou!");
                }
            }).start();
        });
    }
}
