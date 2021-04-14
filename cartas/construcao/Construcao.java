package cartas.construcao;

import cartas.Carta;

public abstract class Construcao extends Carta {

    protected int vida, alcance;
    protected double velAtq;

    public void printStatus() {
        System.out.format("vida: %d, dano: %d, alcance: %d, velAtq: %.1f, custo: %d", this.vida, this.dano, this. alcance, this.velAtq, this.custo);
    }
}