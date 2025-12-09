package default_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GridPanel extends JPanel {
    private final GameEngine engine;
    private final int TILE = 48; // ajusta para 32/48 dependendo do sprite
    private int buyMode = 0; // 0 = nada, 1/2/3 = tipo torre selecionada

    public GridPanel(GameEngine engine) {
        this.engine = engine;
        setPreferredSize(new Dimension(engine.getCaminhos()[0].tamanho * TILE, engine.getCaminhos().length * TILE));
        setBackground(new Color(40, 40, 40));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX() / TILE;
                int row = e.getY() / TILE;
                if (row < 0 || row >= engine.getCaminhos().length) return;
                if (col < 0 || col >= engine.getCaminhos()[0].tamanho) return;

                if (buyMode > 0) {
                    try {
                        engine.buyTower(buyMode, row, col);
                    } catch (RuntimeException ex) {
                        JOptionPane.showMessageDialog(GridPanel.this, ex.getMessage(), "Erro ao comprar torre", JOptionPane.ERROR_MESSAGE);
                    }
                    buyMode = 0;
                    repaint();
                } else {
                    // clique padrão: tentar upgrade no tile (se houver torre)
                    try {
                        engine.upgradeTowerAt(row, col);
                    } catch (RuntimeException ex) {
                        // ignore ou notificar
                    }
                    repaint();
                }
            }
        });
    }

    public void setBuyMode(int tipo) {
        this.buyMode = tipo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Caminho[] caminhos = engine.getCaminhos();

        for (int linha = 0; linha < caminhos.length; linha++) {
            char[] trilha = caminhos[linha].trilha;
            for (int col = 0; col < caminhos[0].tamanho; col++) {
                char c = '.';
                if (col < trilha.length) c = trilha[col];

                Image sprite = SpriteLoader.getSpriteForChar(c);
                g.drawImage(sprite, col * TILE, linha * TILE, TILE, TILE, this);

                g.setColor(new Color(255, 255, 255, 30));
                g.drawRect(col * TILE, linha * TILE, TILE, TILE);
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 14));
        g.drawString("Vida: " + engine.getBase().vida, 8, getHeight() - 36);
        g.drawString("Moedas: " + engine.getMoeda().getMoeda(), 8, getHeight() - 18);
        g.drawString("Wave: " + engine.getCurrentWave(), getWidth() - 100, getHeight() - 18);
    }
}

