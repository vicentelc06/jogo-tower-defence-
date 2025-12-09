package default_package;

import javax.swing.*;

public class MainInterface {
    public static void main(String[] args) {
        SpriteLoader.loadDefaultSprites();

        GameEngine engine = new GameEngine();

        SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow(engine);

            new Timer(2000, e -> {

                engine.tick();
                window.getGrid().repaint();

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
