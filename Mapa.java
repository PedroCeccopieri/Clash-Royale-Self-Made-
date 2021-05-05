import essenciais.*;
import essenciais.ambiente.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Mapa extends JPanel {

    ArrayList<Peca> tabuleiro = new ArrayList<Peca>();

    public Mapa() {
        this.setPreferredSize(new Dimension(384,480));

        inicializarMapa();
        inicializarTorres();
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
        // Torres superiores //
        tabuleiro.add(new Torre(1,2));
        tabuleiro.add(new Torre(5,1));
        tabuleiro.add(new Torre(9,2));
        // Torres inferiores //
        tabuleiro.add(new Torre(1,11));
        tabuleiro.add(new Torre(5,12));
        tabuleiro.add(new Torre(9,11));
    }

    public void addCarta(Peca p) {
        tabuleiro.add(p);
    }

    public void paint (Graphics g) {
    	super.paint(g);
        for (int i = 0; i < tabuleiro.size(); i++) {
            tabuleiro.get(i).paint(g);
        }
    }
}