package essenciais.cartas.feitico;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaBolaDeFogo extends Carta {

    public CartaBolaDeFogo () {

        this.custo = 4;

        this.sprite = new ImageIcon("./sprites/cartas/boladefogo.png").getImage();
    }
}