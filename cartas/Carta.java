package cartas;

public abstract class Carta {

    protected int custo, dano;
    protected int posx, posy;

    public abstract void printStatus();

    public void spawn(int x, int y) {
        this.posx = x;
        this.posy = y;
    }

    public int[] getPos() {
        int[] p = {this.posx,this.posy};
        return p;
    }
}