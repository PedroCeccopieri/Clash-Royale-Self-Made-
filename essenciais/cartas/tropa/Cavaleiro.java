package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

public class Cavaleiro extends Tropa {

    public Cavaleiro (int x, int y) {
        super(x,y);

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