package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaCavaleiro extends Carta {

    public CartaCavaleiro () {

        this.sprite = new ImageIcon("./sprites/cartas/cavaleiro.png").getImage();
    }
}