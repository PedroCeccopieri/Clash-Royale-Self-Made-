package essenciais.cartas.construcao;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaXBesta extends Carta {

    public CartaXBesta () {

        this.custo = 6;

        this.sprite = new ImageIcon("./sprites/cartas/xbesta.png").getImage();
    }
}