package default_package.interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBase extends JFrame implements ActionListener {

    JButton iniciar;
    boolean start = false;
    JLabel dinheiro;
    JLabel vidaBase;
    JPanel informacoes;
    private int quantidadeMoedas = 0;
    private int vidaDaBase = 0;
    Mapa mapa;


    public FrameBase(){


        dinheiro = new JLabel();
        dinheiro.setText("DINHEIROS: $" + quantidadeMoedas);
        dinheiro.setHorizontalTextPosition(JLabel.CENTER);
        dinheiro.setVerticalTextPosition(JLabel.TOP);
        dinheiro.setForeground(Color.green);
        dinheiro.setFont(new Font("MV Boli", Font.PLAIN, 15));

        vidaBase = new JLabel();
        vidaBase.setText("VIDA DA BASE: " + vidaDaBase);
        vidaBase.setHorizontalTextPosition(JLabel.CENTER);
        vidaBase.setVerticalTextPosition(JLabel.TOP);
        vidaBase.setForeground(Color.red);
        vidaBase.setFont(new Font("MV Boli", Font.PLAIN, 15));

        dinheiro.setHorizontalAlignment(SwingConstants.CENTER);
        vidaBase.setHorizontalAlignment(SwingConstants.CENTER);

        informacoes = new JPanel();
        informacoes.setPreferredSize(new Dimension(850, 60));
        informacoes.setBackground(Color.black);
        informacoes.setLayout(new GridLayout(2, 1));
        informacoes.setVisible(false);
        informacoes.add(dinheiro);
        informacoes.add(vidaBase);

        mapa = new Mapa();
        mapa.setVisible(false);


        iniciar = new JButton();
        iniciar.setBounds(110, 100, 250, 100);
        iniciar.addActionListener(this);
        iniciar.setText("START");
        iniciar.setFocusable(false);
        iniciar.setHorizontalTextPosition(JButton.CENTER);
        iniciar.setVerticalTextPosition(JButton.CENTER);
        iniciar.setFont(new Font("Comic Sans", Font.BOLD, 14));
        iniciar.setForeground(new Color(191, 255, 133));
        iniciar.setBackground(new Color(255, 52, 84));
        iniciar.setBorder(BorderFactory.createEtchedBorder());

        this.setTitle("TÍTULO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setResizable(false);
        this.setSize(850, 620);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(245, 186, 49));
        this.add(informacoes);
        this.add(mapa);
        this.add(iniciar);
    }

    public void setQuantidadeMoedas(int quantidade) {
        this.quantidadeMoedas = quantidade;
        atualizarLabelMoedas();
    }

    private void atualizarLabelMoedas() {
        dinheiro.setText("DINHEIROS: $" + quantidadeMoedas);
        dinheiro.repaint();
    }

    public void setVidaDaBase(int vida) {
        this.vidaDaBase = vida;
        atualizarLabelVidaBase();
    }

    private void atualizarLabelVidaBase(){
        vidaBase.setText("VIDA DA BASE: " + vidaDaBase);
        vidaBase.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iniciar){
            iniciar.setVisible(false);
            start = true;
            informacoes.setVisible(true);
            mapa.setVisible(true);
        }
    }

    public boolean getStart(){return start;}

}
