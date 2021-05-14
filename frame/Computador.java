package frame;

import javax.swing.Timer;
import java.util.Random;

import essenciais.entidades.tropa.*;
import essenciais.entidades.feitico.*;
import essenciais.entidades.construcao.*;

public class Computador {

    private Random rand = new Random();

    Timer t;
    Mapa m;

    public Computador(Timer t, Mapa m) {

        this.t = t;
        this.m = m;
    }

    public void jogar() {

        int escolha = rand.nextInt(8);
        int x = rand.nextInt(12);
        int y = rand.nextInt(7);

        while (m.isTorre(x,y)) {
            x = rand.nextInt(12);
            y = rand.nextInt(7);
        }


        switch (escolha) {
            case 0:
                m.addCarta(new Cavaleiro(x, y, 1, t, m));
                break;
            case 1:
                m.addCarta(new Arqueira(x, y, 1, t, m));
                break;
            case 2:
                m.addCarta(new Gigante(x, y, 1, t, m));
                break;
            case 3:
                m.addCarta(new Mago(x, y, 1, t, m));
                break;
            case 4:
                m.addCarta(new EsqueletoBomba(x, y, 1, t, m));
                break;
            case 5:
                m.addCarta(new ExercitoDeEsqueletos(x, y, 1, t, m));
                break;
            case 6:
                m.addCarta(new XBesta(x, y, 1, t, m));
                break;
            case 7:
                y = rand.nextInt(15);
                m.addCarta(new BolaDeFogo(x, y, 1, t, m));
                break;
        }

    }

}