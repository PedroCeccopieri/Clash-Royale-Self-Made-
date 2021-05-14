package frame;

import java.io.File;
import java.io.FileWriter;

import java.util.Scanner;

import java.awt.*;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Placar extends JFrame {

    private int j1, j2, n;

    private JLabel placar;

    public Placar(int n) {
        this.n = n;

        this.setName("placar");
        this.setPreferredSize(new Dimension(384,480));
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        read();

        this.placar = new JLabel();
        placar.setText("Jogador1: " + j1 + "/ Jogador2: " + j2);

        this.add(placar);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void read() {
        File file = new File("./frame/placar.txt");
        Scanner scan = null;
        try {
             scan = new Scanner(file);
        } catch (Exception e) {
            System.out.println("placar.txt nao encontrado");
        }

        if (scan != null) {
            this.j1 = scan.nextInt();
            this.j2 = scan.nextInt();
        }
    }

    public void write() {

        if (this.n == 0) this.j1 += 1;
        if (this.n == 1) this.j2 += 1;

        FileWriter writer = null;

        try {
            writer = new FileWriter("./frame/placar.txt");
            writer.write(j1 + "\n" + j2);
            writer.close();
        } catch (Exception e) {
            System.out.println("placar.txt nao encontrado");
        }
    }
}