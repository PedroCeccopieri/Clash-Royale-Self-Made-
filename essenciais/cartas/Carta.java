package essenciais.cartas;

import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Carta {

    protected Image sprite;
    protected int x, y, w, h;
    protected int custo;

    public Carta () {

        this.x = 0;
        this.y = 0;
        this.w = 96;
        this.h = 116;
    }

    public int getX() { 
        return this.x;
    }

    public int getY() { 
        return this.y;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }

    public int getCusto() {
        return this.custo;
    }

    public void setpos(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
   
        g2d.drawImage(sprite, this.x, this.y, null);
    }
}