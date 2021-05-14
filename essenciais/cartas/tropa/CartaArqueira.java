package essenciais.cartas.tropa;

import javax.swing.ImageIcon;

import essenciais.cartas.Carta;

public class CartaArqueira extends Carta {

    public CartaArqueira () {

        this.custo = 3;

        this.sprite = new ImageIcon("./sprites/cartas/arqueira.png").getImage();
    }
}