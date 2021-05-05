package essenciais.cartas.feitico;

import javax.swing.*;

public class BolaDeFogo extends Feitico {

    public BolaDeFogo(int x, int y) {
        super(x,y);
        this.custo = 4;
        this.dano = 325;
        this.raio = 1;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/feitico/boladefogo56.png").getImage();
    }
}