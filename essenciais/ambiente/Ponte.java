package essenciais.ambiente;

import javax.swing.*;

public class Ponte extends Ambiente {

    public Ponte(int x, int y) {
        super(x,y);
        this.sprite = new ImageIcon("./sprites/ambiente/ponte.png").getImage();
    }
}