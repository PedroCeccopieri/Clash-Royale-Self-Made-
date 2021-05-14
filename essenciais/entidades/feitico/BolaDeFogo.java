package essenciais.entidades.feitico;

import frame.Mapa;

import javax.swing.*;

import javax.swing.Timer;

public class BolaDeFogo extends Feitico {

    public BolaDeFogo(int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);
        
        this.vida = 100;
        this.dano = 325;
        this.raio = 4;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/feitico/boladefogo56.png").getImage();
    }

    protected void explodir() {

        for (int x = (this.x - raio); x < (this.x + raio); x++) {
            for (int y = (this.y - raio); y < (this.y + raio); y++) {
                if (m.isTorre(x,y)) m.getTorre(x,y).tomarDano((int) (this.dano * 1 / 10));
                else if (m.getEntidadeNoPonto(x,y) != null) this.darDano(m.getEntidadeNoPonto(x,y));
            }
        }

        this.vida -= this.dano;
    }
}