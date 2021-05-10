package essenciais.entidades.construcao;

import frame.Mapa;

import javax.swing.*;

import javax.swing.Timer;

public class XBesta extends Construcao {

    public XBesta(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);
        this.custo = 6;
        this.vida = 1000;
        this.dano = 25;
        this.alcance = 4;
        this.velAtq = 0.3;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/construcao/xbesta.png").getImage();
    }
}