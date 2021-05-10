package essenciais.entidades.tropa;

import frame.Mapa;

import essenciais.entidades.Entidade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Math;

public abstract class Tropa extends Entidade implements ActionListener {

    Timer t;
    
    protected int vida, alcance;
    protected double velAtq, velMov;

    private int ladoDeSpawn;

    int destinoX = -1, destinoY = -1;

    public Tropa(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        if (this.y > 7) ladoDeSpawn = -1;
        if (this.y < 7) ladoDeSpawn = 1;

        this.t = t;

        t.addActionListener(this);
    }

    private void irPara(int x, int y) {

        int prox = this.x, proy = this.y;

        if (x != this.x) {
            if (x < this.x) prox -= 1;
            else if (x > this.x) prox += 1;
        }

        if (y != this.y) {
            if (y < this.y) proy -= 1;
            else if (y > this.y) proy += 1;
        }

        if (m.isTorre(prox, proy)) {
            if (!m.isTorre(this.x, proy)) prox = this.x;
            else if (!m.isTorre(this.x + this.ladoDeSpawn, proy)) prox = this.x + this.ladoDeSpawn;
            else if (!m.isTorre(this.x - this.ladoDeSpawn, proy)) prox = this.x - this.ladoDeSpawn;
        }

        this.x = prox;
        this.y = proy;
    }

    private boolean passouDaPonte() {

        if (this.ladoDeSpawn == 1 && this.y > 7) return true;
        else if (this.ladoDeSpawn == -1 && this.y < 7) return true;
        else return false;
    }

    private int ponteMaisPerto() {

        int pontes[] = {1,2,9,10};

        int distanciaAtual, ponteEscolida = 1;
        distanciaAtual = Math.abs(pontes[0] - this.x);

        for (int i = 0; i < 4; i++) {
            int d = Math.abs(pontes[i] - this.x);
            if (d < distanciaAtual) ponteEscolida = i;
        }

        return pontes[ponteEscolida];
    }

    private double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }

    private int[] torreMaisPerto() {

        int[] torreEscolhida = null;
        double distancia;

        int[][] torres = m.getTorreInimiga(this.ladoDeSpawn);

        distancia = getDist(this.x, this.y, torres[0][0], torres[0][1]);
        torreEscolhida = torres[0];

        for (int[] t : torres) {
            if (getDist(this.x, this.y, t[0], t[1]) < distancia) {
                distancia = getDist(this.x, this.y, t[0], t[1]);
                torreEscolhida = new int[] {t[0], t[1]};
            }
            if (getDist(this.x, this.y, t[0] + 1, t[1]) < distancia) {
                distancia = getDist(this.x, this.y, t[0] + 1, t[1]);
                torreEscolhida = new int[] {t[0] + 1, t[1]};
            }
            if (getDist(this.x, this.y, t[0], t[1] + 1) < distancia) {
                distancia = getDist(this.x, this.y, t[0], t[1] + 1);
                torreEscolhida = new int[] {t[0], t[1] + 1};
            }
            if (getDist(this.x, this.y, t[0] + 1, t[1] + 1) < distancia) {
                distancia = getDist(this.x, this.y, t[0] + 1, t[1] + 1);
                torreEscolhida = new int[] {t[0] + 1, t[1] + 1};
            }
        }

        return torreEscolhida;
    }

    private void escolherAlvo() {

        int[] tmp = torreMaisPerto();

        this.destinoX = tmp[0];
        this.destinoY = tmp[1] - ladoDeSpawn;
    }

    public void actionPerformed(ActionEvent e) {

        escolherAlvo();

        if (destinoX != -1 && destinoY != -1) {
            if (!passouDaPonte() && !(this.x == 1 || this.x == 2 || this.x == 9 || this.x == 10) && ladoDeSpawn == 1) {
                irPara(ponteMaisPerto(), 6);
            } else if (!passouDaPonte() && !(this.x == 1 || this.x == 2 || this.x == 9 || this.x == 10) && ladoDeSpawn == -1) {
                irPara(ponteMaisPerto(), 8);
            } else if (!passouDaPonte() && ladoDeSpawn == 1) {
                irPara(this.x, y + ladoDeSpawn);
            } else if (!passouDaPonte() && ladoDeSpawn == -1) {
                irPara(this.x, y + ladoDeSpawn);
            } else {
                irPara(destinoX, destinoY);
            }
        }
    }
}