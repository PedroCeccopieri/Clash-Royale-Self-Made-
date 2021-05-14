package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaEsqueletoBomba extends Carta {

    public CartaEsqueletoBomba () {

        this.custo = 2;

        this.sprite = new ImageIcon("./sprites/cartas/esqueletoBomba.png").getImage();
    }
}