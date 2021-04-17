package cartas.feitico;

import cartas.Carta;

public abstract class Feitico extends Carta {

    protected int raio;

    public void printStatus() {
        System.out.format("dano: %d, area: %d, custo: %d\n", this.dano, this. area, this.custo);
    }

    public int darDano() {
        return this.dano;
    }
}