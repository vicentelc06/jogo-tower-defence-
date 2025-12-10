package default_package.interface_grafica;

import default_package.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compras implements ActionListener{

    JFrame loja = new JFrame();
    JButton fim = new JButton();
    JPanel itens = new JPanel();
    JPanel infoItens = new JPanel();
    JButton comprarTorre1 = new JButton();
    JButton comprarTorre2 = new JButton();
    JButton comprarTorre3 = new JButton();
    JLabel infoTorre1 = new JLabel();
    JLabel infoTorre2 = new JLabel();
    JLabel infoTorre3 = new JLabel();
    int tipo;
    boolean isOpen;

    public Compras(){

        this.isOpen = true;
        this.tipo = -1;

        ImageIcon torre1 = new ImageIcon("torre1.png");
        ImageIcon torre2 = new ImageIcon("torre2.png");
        ImageIcon torre3 = new ImageIcon("torre3.png");

        fim.setBounds(320, 530, 200, 40);
        fim.setFocusable(false);
        fim.setText("VOLTAR");
        fim.addActionListener(this);

        itens.setBounds(50, 50, 660, 360);
        itens.setBackground(Color.GRAY);
        itens.setLayout(new GridLayout(1, 3, 10, 10));
        itens.add(comprarTorre1);
        itens.add(comprarTorre2);
        itens.add(comprarTorre3);

        comprarTorre1.setText("$ " + Constantes.CUSTO_TORRE_1);
        comprarTorre1.setHorizontalTextPosition(JButton.CENTER);
        comprarTorre1.setVerticalTextPosition(JButton.BOTTOM);
        comprarTorre1.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        comprarTorre1.setIcon(torre1);
        //comprarTorre1.setIconTextGap(-5);
        comprarTorre1.setBackground(Color.ORANGE);
        comprarTorre1.setFocusable(false);
        comprarTorre1.setBorder(BorderFactory.createEtchedBorder());

        comprarTorre2.setText("$ " + Constantes.CUSTO_TORRE_2);
        comprarTorre2.setHorizontalTextPosition(JButton.CENTER);
        comprarTorre2.setVerticalTextPosition(JButton.BOTTOM);
        comprarTorre2.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        comprarTorre2.setIcon(torre2);
        //comprarTorre2.setIconTextGap(-5);
        comprarTorre2.setBackground(Color.ORANGE);
        comprarTorre2.setFocusable(false);
        comprarTorre2.setBorder(BorderFactory.createEtchedBorder());

        comprarTorre3.setText("$ " + Constantes.CUSTO_TORRE_3);
        comprarTorre3.setHorizontalTextPosition(JButton.CENTER);
        comprarTorre3.setVerticalTextPosition(JButton.BOTTOM);
        comprarTorre3.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        comprarTorre3.setIcon(torre3);
        //comprarTorre3.setIconTextGap(-5);
        comprarTorre3.setBackground(Color.ORANGE);
        comprarTorre3.setFocusable(false);
        comprarTorre3.setBorder(BorderFactory.createEtchedBorder());

        infoItens.setBounds(50, 410, 660, 100);
        infoItens.setLayout(new GridLayout(1, 3, 10, 10));
        infoItens.setBackground(Color.GRAY);
        infoItens.add(infoTorre1);
        infoItens.add(infoTorre2);
        infoItens.add(infoTorre3);

        infoTorre1.setText("Vida = 12 Dano = 2");
        infoTorre1.setHorizontalAlignment(JLabel.CENTER);
        infoTorre1.setVerticalAlignment(JLabel.CENTER);
        infoTorre1.setForeground(Color.green);
        infoTorre1.setFont(new Font("Comic Sans", Font.BOLD, 12));

        infoTorre2.setText("Vida = 8 Dano = 1");
        infoTorre2.setHorizontalAlignment(JLabel.CENTER);
        infoTorre2.setVerticalAlignment(JLabel.CENTER);
        infoTorre2.setForeground(Color.green);
        infoTorre2.setFont(new Font("Comic Sans", Font.BOLD, 12));

        infoTorre3.setText("Vida = 10 Dano = 3");
        infoTorre3.setHorizontalAlignment(JLabel.CENTER);
        infoTorre3.setVerticalAlignment(JLabel.CENTER);
        infoTorre3.setForeground(Color.green);
        infoTorre3.setFont(new Font("Comic Sans", Font.BOLD, 12));

        loja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loja.setLayout(null);
        loja.setSize(850, 620);
        loja.setVisible(true);
        loja.add(fim);
        loja.add(itens);
        loja.add(infoItens);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fim){
            loja.dispose();
            isOpen = false;
        }
        else if(e.getSource() == comprarTorre1){
            tipo = 1;
        }
        else if(e.getSource() == comprarTorre2){
            tipo = 2;
        }
        else if(e.getSource() == comprarTorre3){
            tipo = 3;
        }
    }


    public int getTipo(){return tipo;}

    public boolean getIsOpen(){return isOpen;}


}
