package essenciais;

import java.util.ArrayList;
import cartas.Carta;
import essenciais.Torre;

public class Mapa {

    protected int gridX, gridY;
    private int rio;
    private int[] pontes;
    private ArrayList<Carta> cartas = new ArrayList<Carta>();
    private ArrayList<Torre> torres = new ArrayList<Torre>();

    public Mapa () {
        this.gridX = 12;
        this.gridY = 15;
        this.rio = 7;
        this.pontes = new int[] {1,2,9,10};
    }

    public void inicializarTorres () {
        torres.add(new Torre(1,2)); torres.add(new Torre(5,1)); torres.add(new Torre(9,2)); // Torres superiores //
        torres.add(new Torre(1,11)); torres.add(new Torre(5,12)); torres.add(new Torre(9,11)); // Torres inferiores //
    }

    public void addCarta(Carta c, int x, int y) {
        c.spawn(x,y);
        cartas.add(c);
    }
}