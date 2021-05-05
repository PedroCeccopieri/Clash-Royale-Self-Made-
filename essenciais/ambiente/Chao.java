package essenciais.ambiente;

import javax.swing.*;

public class Chao extends Ambiente {

    public Chao(int x, int y) {
        super(x,y);
        this.sprite = new ImageIcon("./sprites/ambiente/grama.png").getImage();
    }
}