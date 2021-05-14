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
        Computador comp;

        mapa = new Mapa(evt, timer);
        mao = new Mao(evt, -1); // mao do jogador //
        comp = new Computador(timer, mapa);

        evt.setMapa(mapa);
        evt.setMao(mao);
        evt.setComp(comp);

        new Menu(new Frame(mapa, mao));
    }
}