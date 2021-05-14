package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaMago extends Carta {

    public CartaMago () {

        this.custo = 5;

        this.sprite = new ImageIcon("./sprites/cartas/mago.png").getImage();
    }
}