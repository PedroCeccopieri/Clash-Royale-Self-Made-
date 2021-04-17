package cartas.tropa;

import cartas.Carta;

public abstract class Tropa extends Carta {

    protected int vida, alcance;
    protected double velAtq, velMov;

    public void printStatus() {
        System.out.format("vida: %d, dano: %d, alcance: %d, velAtq: %.1f, velMov: %.1f, custo: %d\n", this.vida, this.dano, this. alcance, this.velAtq, this.velMov, this.custo);
    }

    public void atacar() {

    }

    public void andar() {

    }

    public void mirar() {

    }
}