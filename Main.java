import frame.*;
import essenciais.*;

import essenciais.ambiente.*;

import essenciais.cartas.tropa.*;
import essenciais.cartas.construcao.*;
import essenciais.cartas.feitico.*;

import essenciais.entidades.tropa.*;
import essenciais.entidades.construcao.*;
import essenciais.entidades.feitico.*;

import javax.swing.Timer;

public class Main {
    
    public static void main(String[] args) {

        Timer timer = new Timer(100, null);
        timer.start();
        
        EventHandler evt = new EventHandler(timer);

        Mapa mapa;
        Mao mao;

        mapa = new Mapa(evt, timer);
        mao = new Mao(evt);

        evt.setMapa(mapa);
        evt.setMao(mao);

        mapa.addCarta(new Cavaleiro(4,6,timer,mapa));

        new Frame(mapa, mao);
    }
}