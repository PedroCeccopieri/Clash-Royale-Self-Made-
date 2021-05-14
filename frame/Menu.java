package frame;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class Menu extends JFrame implements ActionListener {

    Frame f;

    Placar p;
    
    private JButton ok, cancelar, sobre, pontuacao;

    public Menu(Frame f) {

        this.f = f;
        this.p = new Placar(-1);
        
        this.setName("menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(384,480));
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        
        
        this.ok = new JButton("jogar");
        this.sobre = new JButton("sobre");
        this.pontuacao = new JButton("pontuacao");
        this.cancelar = new JButton("sair");

        this.ok.addActionListener(this);
        this.sobre.addActionListener(this);
        this.pontuacao.addActionListener(this);
        this.cancelar.addActionListener(this);
        
        this.add(ok);
        this.add(sobre);
        this.add(pontuacao);
        this.add(cancelar);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            f.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == cancelar) java.lang.System.exit(0);

        if (e.getSource() == sobre) new Creditos();

        if (e.getSource() == pontuacao) {
            p.setVisible(true);
        }
    }
}
    

