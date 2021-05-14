package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.Timer;

public class Frame extends JFrame {
    
    public Frame(Mapa mapa, Mao maoDoJogador) {
        
        this.setName("main frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(384,480);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.add(mapa, BorderLayout.NORTH);
        this.add(maoDoJogador, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
}