package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Mago extends Tropa {

    public Mago (int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);

        this.vida = 340;
        this.dano = 130;
        this.alcance = 4;
        this.velAtq = 1.4;
        this.velMov = 1.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/mago56.png").getImage();
    }

}