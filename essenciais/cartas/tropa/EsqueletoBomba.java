package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

public class EsqueletoBomba extends Tropa {

    public EsqueletoBomba (int x, int y) {
        super(x,y);

        this.custo = 1;
        this.vida = 32;
        this.dano = 32;
        this.alcance = 1;
        this.velAtq = 1.0;
        this.velMov = 2.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/esqueletobomba32.png").getImage();
    }
}