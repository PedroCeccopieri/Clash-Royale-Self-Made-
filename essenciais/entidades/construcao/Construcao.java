package essenciais.entidades.construcao;

import frame.Mapa;

import essenciais.entidades.*;

import javax.swing.Timer;

public abstract class Construcao extends Entidade {

    protected int alcance;
    protected double velAtq;

    public Construcao(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);
    }

}