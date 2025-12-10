package default_package.interface_grafica;

import default_package.Constantes;

import javax.swing.*;
import java.awt.*;

public class Mapa extends JPanel{

    JLabel[] solo;

    public Mapa(){

        solo = new JLabel[100];

        for(int i = 0; i < (Constantes.CAMINHOS_LINHAS * Constantes.CAMINHOS_COLUNAS); i++){
            solo[i] = new JLabel();
            solo[i].setBackground(Color.green);
            solo[i].setOpaque(true);
            this.add(solo[i]);
        }

        this.setPreferredSize(new Dimension(700, 480));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(Constantes.CAMINHOS_LINHAS, Constantes.CAMINHOS_COLUNAS, 10, 10));
        this.setVisible(true);

    }

}
