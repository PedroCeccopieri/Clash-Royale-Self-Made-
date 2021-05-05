package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

public class Arqueira extends Tropa {

    public Arqueira (int x, int y) {
        super(x,y);

        this.custo = 3;
        this.vida = 120;
        this.dano = 40;
        this.alcance = 4;
        this.velAtq = 1.2;
        this.velMov = 1.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/arqueira56.png").getImage();
    }
}