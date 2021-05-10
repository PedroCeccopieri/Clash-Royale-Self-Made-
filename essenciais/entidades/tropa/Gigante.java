package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.ImageIcon;

import javax.swing.Timer;

public class Gigante extends Tropa {

    public Gigante (int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        this.custo = 5;
        this.vida = 1800;
        this.dano = 120;
        this.alcance = 1;
        this.velAtq = 1.5;
        this.velMov = 0.5;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/gigante64.png").getImage();
    }
}