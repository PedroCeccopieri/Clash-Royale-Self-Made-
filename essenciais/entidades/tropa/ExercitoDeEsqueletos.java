package essenciais.entidaeds.tropa;

import frame.Mapa;

import java.util.ArrayList;
import java.awt.Graphics;

import javax.swing.Timer;

public class ExercitoDeEsqueletos extends Tropa {

    private int quantidade;
    private ArrayList<Esqueleto> esqueletos = new ArrayList<Esqueleto>();

    public ExercitoDeEsqueletos (int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        this.custo = 3;
        this.quantidade = 15;
    }

    public void criarExercito() {
        for (int i = 0; i < quantidade; i++) {
            Esqueleto e = new Esqueleto(x, y);
            esqueletos.add(e);
        }
    }

    public void paint (Graphics g) {

        for (Esqueleto e : esqueletos) {
            e.paint(g);
        }
    }
}