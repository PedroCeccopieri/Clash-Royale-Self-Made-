package cartas.feitico;

import cartas.Carta;

public abstract class Feitico extends Carta {

    protected int area;

    public void printStatus() {
        System.out.format("dano: %d, area: %d, custo: %d", this.dano, this. area, this.custo);
    }
}