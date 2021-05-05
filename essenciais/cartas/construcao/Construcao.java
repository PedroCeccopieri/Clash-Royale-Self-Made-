package essenciais.cartas.construcao;

import essenciais.cartas.*;

public abstract class Construcao extends Carta {

    protected int vida, alcance;
    protected double velAtq;

    public Construcao(int x, int y) {
        super(x,y);
    }

}