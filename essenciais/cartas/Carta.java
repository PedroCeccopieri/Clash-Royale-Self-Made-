package essenciais.cartas;

import essenciais.Peca;

public abstract class Carta extends Peca {

    protected int custo, dano;

    public Carta(int x, int y) {
        this.x = x;
        this.y = y;
    }
}