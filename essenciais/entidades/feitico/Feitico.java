package essenciais.entidades.feitico;

import frame.Mapa;

import essenciais.entidades.Entidade;

import javax.swing.Timer;

public abstract class Feitico extends Entidade {

    protected int raio;

    public Feitico(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);
    }
}