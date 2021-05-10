package frame;

import essenciais.Peca;
import essenciais.ambiente.*;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;


public class Mapa extends JPanel implements ActionListener {

    Timer timer;
    
    EventHandler evt;

    ArrayList<Peca> tabuleiro = new ArrayList<Peca>();

    int[][] cordsTorres = {{1,2},{5,1},{9,2},{1,11},{5,12},{9,11}};

    public Mapa(EventHandler evt, Timer timer) {

        this.timer = timer;
        this.timer.addActionListener(this);

        this.evt = evt;

        this.setPreferredSize(new Dimension(384,480));

        inicializarMapa();
        inicializarTorres();

        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
    }

    private void inicializarMapa() {

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 15; y++) {
                if (y == 7) {
                    if (x == 1 || x == 2 || x == 9 || x == 10) tabuleiro.add(new Ponte(x,y));
                    else tabuleiro.add(new Rio(x,y));
                } else {
                    tabuleiro.add(new Chao(x,y));
                }
            }
        }
    }

    private void inicializarTorres() {
        
        for (int[] is : cordsTorres) {
        //    tabuleiro.add(new Torre(is[0],is[1]));
        }
    }

    public boolean isTorre(int x, int y) {
        for (int i = 0; i < cordsTorres.length; i++) {
            if (x == cordsTorres[i][0] && y == cordsTorres[i][1]) return true;
            else if (x == cordsTorres[i][0] + 1 && y == cordsTorres[i][1]) return true;
            else if (x == cordsTorres[i][0] && y == cordsTorres[i][1] + 1) return true;
            else if (x == cordsTorres[i][0] + 1 && y == cordsTorres[i][1] + 1) return true;
        } return false;
    }

    public int[][] getTorreInimiga(int ladoDeSpawn) {
        int[][] torres = new int[3][2];
        int qnt = 0;
        for (Peca t : tabuleiro) {
            if (t instanceof Torre) {
                Torre t2 = (Torre) t;
                if (t2.ladoDeSpawn != ladoDeSpawn) {
                    torres[qnt] = new int[] {t2.getX(), t2.getY()};
                    qnt++;
                }
            }
        }
        return torres;
    }

    private void addCarta(Peca p) {
        tabuleiro.add(p);
        repaint();
    }

    public void paint (Graphics g) {
    	super.paint(g);
        for (int i = 0; i < tabuleiro.size(); i++) {
            tabuleiro.get(i).paint(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }



    private class ClickListener extends MouseInputAdapter {
        public void mousePressed (MouseEvent e) {
            if (e.getY() > 8 * 32) {
                Peca p = evt.SpawnCarta(e.getPoint());
                if (p != null) addCarta(p);
            }
        }
    }
}