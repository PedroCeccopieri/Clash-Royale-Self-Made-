package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

public class Mago extends Tropa {

    public Mago (int x, int y) {
        super(x,y);

        this.custo = 5;
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