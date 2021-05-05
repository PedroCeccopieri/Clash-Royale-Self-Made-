
import essenciais.cartas.construcao.*;
import essenciais.cartas.feitico.*;
import essenciais.cartas.tropa.*;

public class Main {
    
    public static void main(String[] args) {
        
        Mapa mapa = new Mapa();

        new Frame(mapa);

        mapa.addCarta(new XBesta(1,5));
        mapa.addCarta(new BolaDeFogo(3,5));
        mapa.addCarta(new Arqueira(5,5));
        mapa.addCarta(new Cavaleiro(7,5));
        mapa.addCarta(new Gigante(1,9));
        mapa.addCarta(new Esqueleto(3,9));
        mapa.addCarta(new EsqueletoBomba(5,9));
        mapa.addCarta(new Mago(7,9));
    }
}