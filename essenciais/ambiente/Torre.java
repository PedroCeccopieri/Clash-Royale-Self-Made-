package essenciais.ambiente;

import java.awt.*;
import javax.swing.*;

public class Torre extends Ambiente {

    private int vida;
    
    public int ladoDeSpawn;

    public Torre(int x, int y) {
        super(x,y);

        this.vida = 2000;

        if (this.y > 7) ladoDeSpawn = -1;
        if (this.y < 7) ladoDeSpawn = 1;

        this.sprite = new ImageIcon("./sprites/ambiente/torre.png").getImage();
    }

    public int getVida() {
        return this.vida;
    }

    public void tomarDano(int dano) {
        this.vida -= dano;
    }

    public void paint (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
   
        g2d.drawImage(sprite, this.x * this.w, this.y * this.h, null);
        g2d.drawImage(sprite, (this.x + 1) * this.w, this.y * this.h, null);
        g2d.drawImage(sprite, this.x * this.w, (this.y + 1) * this.h, null);
        g2d.drawImage(sprite, (this.x + 1) * this.w, (this.y + 1) * this.h, null);
        
    }
}