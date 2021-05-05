package essenciais.ambiente;

import essenciais.Peca;

public abstract class Ambiente extends Peca {

    public Ambiente(int x, int y) {

        this.x = x;
        this.y = y;
        this.w = 32;
        this.h = 32;
    }
}