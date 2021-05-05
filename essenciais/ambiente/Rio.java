package essenciais.ambiente;

import javax.swing.*;

public class Rio extends Ambiente {

    public Rio(int x, int y) {
        super(x,y);
        this.sprite = new ImageIcon("./sprites/ambiente/rio.png").getImage();
    }
}