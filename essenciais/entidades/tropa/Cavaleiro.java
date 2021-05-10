package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Cavaleiro extends Tropa {

    public Cavaleiro (int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        this.custo = 3;
        this.vida = 650;
        this.dano = 80;
        this.alcance = 1;
        this.velAtq = 1.2;
        this.velMov = 1.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/cavaleiro56.png").getImage();
    }
}