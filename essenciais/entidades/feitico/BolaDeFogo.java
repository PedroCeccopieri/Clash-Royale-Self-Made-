package essenciais.entidades.feitico;

import frame.Mapa;

import javax.swing.*;

import javax.swing.Timer;

public class BolaDeFogo extends Feitico {

    public BolaDeFogo(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);
        this.custo = 4;
        this.vida = 1;
        this.dano = 325;
        this.raio = 1;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/feitico/boladefogo56.png").getImage();
    }
}