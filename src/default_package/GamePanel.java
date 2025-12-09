package default_package;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameEngine engine;

    public GamePanel(GameEngine engine) {
        this.engine = engine;
        setPreferredSize(new Dimension(700, 400));
        setBackground(Color.BLACK);

        // carrega sprites na inicialização
        SpriteLoader.loadDefaultSprites();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int linhas = 6;
        int colunas = 14;

        int cellW = getWidth() / colunas;
        int cellH = getHeight() / linhas;

        g.setColor(Color.WHITE);
        for (int i = 0; i <= linhas; i++)
            g.drawLine(0, i * cellH, getWidth(), i * cellH);

        for (int j = 0; j <= colunas; j++)
            g.drawLine(j * cellW, 0, j * cellW, getHeight());

        Caminho[] caminhos = engine.getCaminhos();
        if (caminhos == null) return;

        for (int linha = 0; linha < caminhos.length; linha++) {

            char[] trilha = caminhos[linha].trilha;

            for (int col = 0; col < trilha.length; col++) {

                char simbolo = trilha[col];

                Image sprite = SpriteLoader.getSpriteForChar(simbolo);
                if (sprite == null) continue;

                int x = col * cellW;
                int y = linha * cellH;

                g.drawImage(sprite, x, y, cellW, cellH, null);
            }
        }
    }
}
