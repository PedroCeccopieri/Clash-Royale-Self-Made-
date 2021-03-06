package frame;

import java.awt.Point;
import javax.swing.Timer;

import essenciais.Peca;

import essenciais.entidades.tropa.*;
import essenciais.entidades.feitico.*;
import essenciais.entidades.construcao.*;

import essenciais.cartas.Carta;

import essenciais.cartas.tropa.*;
import essenciais.cartas.feitico.*;
import essenciais.cartas.construcao.*;

public class EventHandler {

    Timer t;
    
    Computador comp;
    Mapa mapa;
    Mao mao;
    
    Carta selecionada;

    public EventHandler(Timer t) {

        this.t = t;

    }

    public void setMapa(Mapa m) {
        this.mapa = m;
    }

    public void setMao(Mao m) {
        this.mao = m;
    }

    public void setComp(Computador c) {
        this.comp = c;
    }

    public Peca SpawnCarta(Point p) { // traduz as classes Cartas em Entidades, bota a Entidades no mapa e tira a Carta da mao //

        Peca c = null;

        if (selecionada instanceof CartaCavaleiro) c = new Cavaleiro((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaArqueira) c = new Arqueira((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaGigante) c = new Gigante((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaMago) c = new Mago((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaEsqueletoBomba) c = new EsqueletoBomba((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaExercitoDeEsqueletos) c = new ExercitoDeEsqueletos((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaXBesta) c = new XBesta((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        else if (selecionada instanceof CartaBolaDeFogo) c = new BolaDeFogo((int) p.getX() / 32, (int) p.getY() / 32, mao.ladoDeSpawn, this.t, this.mapa);
        
        mao.atualizarElixir(selecionada.getCusto());
        mao.excluirCarta(selecionada);

        this.comp.jogar();
        
        return c;
    }

    public boolean cartaSelecionadaIsFeitico() {
        if (selecionada instanceof CartaBolaDeFogo) return true;
        else return false;
    }

    public void setCartaSelecionada(Carta c) {
        this.selecionada = c;
    }
}