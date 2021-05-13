package essenciais.entidades;

import frame.Mapa;

import essenciais.Peca;

import javax.swing.Timer;

public abstract class Entidade extends Peca {

    protected Mapa m;

    public int ladoDeSpawn;
    
    protected int vida, custo, dano;
    
    public Entidade(int x, int y, Timer t, Mapa m) {
        this.m = m;
        
        this.x = x;
        this.y = y;

        if (this.y > 7) ladoDeSpawn = -1;
        if (this.y < 7) ladoDeSpawn = 1;
    }

    public int getVida() {
        return this.vida;
    }

    public void morrer() {
        
    }

    protected void darDano(Entidade e) {
        e.vida -= this.dano;
    }
}