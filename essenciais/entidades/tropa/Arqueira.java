package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.ImageIcon;

import javax.swing.Timer;

public class Arqueira extends Tropa {

    public Arqueira (int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        this.custo = 3;
        this.vida = 120;
        this.dano = 40;
        this.alcance = 3;
        this.velAtq = 1.2;
        this.velMov = 1.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/arqueira56.png").getImage();
    }
}