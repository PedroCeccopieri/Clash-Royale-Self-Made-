import cartas.tropa.*;
import cartas.construcao.*;
import cartas.feitico.*;

public class Game {

    public static void main(String[] args) {

        XBesta x = new XBesta();
        BolaDeFogo bdf = new BolaDeFogo();

        Arqueira a = new Arqueira();
        Cavaleiro c = new Cavaleiro();
        EsqueletoBomba eb = new EsqueletoBomba();
        Gigante g = new Gigante();
        Mago m = new Mago();

        x.printStatus();
        System.out.println();
        bdf.printStatus();
        System.out.println();
        a.printStatus();
        System.out.println();
        c.printStatus();
        System.out.println();
        eb.printStatus();
        System.out.println();
        g.printStatus();
        System.out.println();
        m.printStatus();
        System.out.println();
    }
}
