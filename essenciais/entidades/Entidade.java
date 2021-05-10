package essenciais.entidades;

import frame.Mapa;

import essenciais.Peca;

import javax.swing.Timer;

public abstract class Entidade extends Peca {

    protected Mapa m;
    
    protected int custo, dano;
    
    public Entidade(int x, int y, Timer t, Mapa m) {
        this.m = m;
        
        this.x = x;
        this.y = y;
    }
}