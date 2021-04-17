import cartas.tropa.*;
import cartas.construcao.*;
import cartas.feitico.*;
import essenciais.*;

public class Game {

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.inicializarTorres();
        mapa.addCarta(new Cavaleiro(), 5, 4);
        mapa.print();
    }
}
