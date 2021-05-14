package frame;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class Fim extends JFrame {
    
    private JLabel texto;
    private JLabel ganhador;

    public Fim(int n) {
        
        this.setName("fim");
        this.setPreferredSize(new Dimension(384,480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        this.texto = new JLabel();
        this.texto.setText("fim de jogo");

        this.ganhador = new JLabel();

        if (n == 0) this.ganhador.setText("Jogador 1 ganhou!");
        if (n == 1) this.ganhador.setText("Jogador 2 ganhou!");
        
        this.add(texto);
        this.add(ganhador);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
    

