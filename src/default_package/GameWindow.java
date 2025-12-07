package default_package;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final GameEngine engine;
    private final GridPanel grid;
    private final JPanel side;

    public GameWindow(GameEngine engine) {
        this.engine = engine;
        setTitle("Tower Defense - Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        grid = new GridPanel(engine);
        add(grid, BorderLayout.CENTER);

        side = new JPanel();
        side.setPreferredSize(new Dimension(200, 0));
        side.setLayout(new GridLayout(10, 1, 6, 6));
        side.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(side, BorderLayout.EAST);

        JButton buy1 = new JButton("Comprar Torre 1");
        JButton buy2 = new JButton("Comprar Torre 2");
        JButton buy3 = new JButton("Comprar Torre 3");
        JButton nextWave = new JButton("Iniciar Próxima Onda");
        JButton autoWave = new JButton("Auto Iniciar Ondas");
        JButton upgrade = new JButton("Upgrade (Clique célula)");
        JLabel info = new JLabel("<html><center>Clique em comprar, depois clique no grid<br>ou clique no tile para upgrade</center></html>");
        info.setHorizontalAlignment(SwingConstants.CENTER);

        buy1.addActionListener(e -> grid.setBuyMode(1));
        buy2.addActionListener(e -> grid.setBuyMode(2));
        buy3.addActionListener(e -> grid.setBuyMode(3));
        nextWave.addActionListener(e -> engine.startNextWave());
        upgrade.addActionListener(e -> JOptionPane.showMessageDialog(this, "Clique na célula para tentar upgrade (se houver torre)."));

        side.add(info);
        side.add(buy1);
        side.add(buy2);
        side.add(buy3);
        side.add(upgrade);
        side.add(nextWave);
        side.add(new JLabel()); // espaço
        side.add(new JLabel("Sprites: place .png em /sprites"));
        side.add(new JLabel("Tamanho recomendado: 32 ou 48px"));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public GridPanel getGrid() {
        return grid;
    }
}
