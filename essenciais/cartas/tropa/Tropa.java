package essenciais.cartas.tropa;

import essenciais.cartas.Carta;

public abstract class Tropa extends Carta {

    protected int vida, alcance;
    protected double velAtq, velMov;

    public Tropa(int x, int y) {
        super(x, y);
    }
    
}