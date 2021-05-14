package essenciais.entidades;

import frame.Mapa;

import essenciais.Peca;

import java.awt.event.*;

import javax.swing.Timer;

public abstract class Entidade extends Peca implements ActionListener {

    protected Mapa m;
    protected Timer t;
    
    protected int ticks = 0;

    public int ladoDeSpawn;
    
    protected int vida, dano;
    
    public Entidade(int x, int y, int l, Timer t, Mapa m) { // Pecas que ficam no mapa e interagem entre si e com as torres //
        this.m = m;
        this.t = t;
        
        this.x = x;
        this.y = y;

        this.ladoDeSpawn = l;

        t.addActionListener(this);
    }

    public int getVida() {
        return this.vida;
    }

    public void morrer() {
        t.removeActionListener(this);
    }

    protected void darDano(Entidade e) {
        e.vida -= this.dano;
    }

    public abstract void actionPerformed(ActionEvent e);
}