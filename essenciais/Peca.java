package essenciais;

import java.awt.*;

public abstract class Peca {

    protected int x, y;
    protected int w, h;
    protected Image sprite;


    public Peca() {
        
    }

    public void paint (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
   
        g2d.drawImage(sprite, this.x * this.w, this.y * this.h, null);
    }

    public int getX() { 
        return this.x;
    }

    public int getY() { 
        return this.y;
    }

}