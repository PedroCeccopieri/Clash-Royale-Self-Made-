package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

public class Gigante extends Tropa {

    public Gigante (int x, int y) {
        super(x,y);

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