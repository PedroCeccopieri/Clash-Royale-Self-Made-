package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Esqueleto extends Tropa {

    public Esqueleto (int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);

        this.vida = 32;
        this.dano = 32;
        this.alcance = 1;
        this.velAtq = 1.0;
        this.velMov = 2.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/esqueleto32.png").getImage();
    }
}