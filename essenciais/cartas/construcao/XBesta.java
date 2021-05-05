package essenciais.cartas.construcao;

import javax.swing.*;

public class XBesta extends Construcao {

    public XBesta(int x, int y) {
        super(x,y);
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