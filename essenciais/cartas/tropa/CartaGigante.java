package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaGigante extends Carta {

    public CartaGigante () {

        this.custo = 5;

        this.sprite = new ImageIcon("./sprites/cartas/gigante.png").getImage();
    }
}