package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaExercitoDeEsqueletos extends Carta {

    public CartaExercitoDeEsqueletos () {

        this.custo = 3;

        this.sprite = new ImageIcon("./sprites/cartas/exercitodeesqueletos.png").getImage();
    }
}