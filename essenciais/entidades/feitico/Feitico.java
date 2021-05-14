package essenciais.entidades.feitico;

import frame.Mapa;

import essenciais.entidades.Entidade;

import java.awt.event.*;

import javax.swing.Timer;

import java.util.ArrayList;

public abstract class Feitico extends Entidade implements ActionListener {

    protected int raio;
    protected double delay = 1.3;

    public Feitico(int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);
    }

    protected abstract void explodir();

    public void actionPerformed(ActionEvent e) {

        if (this.ticks >= 1000 * this.delay) {
            explodir();
        } this.ticks += 100;
    } 
}