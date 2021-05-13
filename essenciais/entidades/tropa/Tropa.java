package essenciais.entidades.tropa;

import frame.Mapa;

import essenciais.entidades.Entidade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Math;

import java.util.ArrayList;

public abstract class Tropa extends Entidade implements ActionListener {

    Timer t;
    
    int ticks = 1000;
    
    protected int alcance;
    protected double velAtq, velMov;

    int destinoX = -1, destinoY = -1;

    public Tropa(int x, int y, Timer t, Mapa m) {
        super(x, y, t, m);

        this.t = t;

        t.addActionListener(this);
    }

    private int lowerBound(int n) {
        if (!(n % 100 == 0)) return n - (n % 100);
        else return n;
    }

    private double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }

    public void morrer() {
        t.removeActionListener(this);
    }

    private void irPara(int x, int y) {

        int prox = this.x, proy = this.y;

        if ((this.y < 7 && y > 7) || (this.y > 7 && y < 7)) {
            if ((this.y == 6 || this.y == 8)  && !(this.x == 1 || this.x == 2 || this.x == 9 || this.x == 10)) {
                irPara(m.ponteMaisPerto(this.x), this.y);
                return;
            }
            if ((this.y == 6 || this.y == 8)  && (this.x == 1 || this.x == 2 || this.x == 9 || this.x == 10)) {
                irPara(this.x, 7);
                return;
            }
        }

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

    protected void escolherAlvo() {

        ArrayList<Entidade> entidades = m.entidadesNaArea(this, 3);

        if (entidades.size() > 0) {

            Entidade inimigoAlvo = null;
            double dist = -1;

            for (int i = 0; i < entidades.size(); i++) {
                if (dist != -1) {
                    if (getDist(this.x, this.y, entidades.get(i).getX(), entidades.get(i).getY()) < dist) {
                        dist = getDist(this.x, this.y, entidades.get(i).getX(), entidades.get(i).getY());
                        inimigoAlvo = entidades.get(i);
                    }
                } else {
                    dist = getDist(this.x, this.y, entidades.get(i).getX(), entidades.get(i).getY());
                    inimigoAlvo = entidades.get(i);
                }
            }

            this.destinoX = inimigoAlvo.getX();
            this.destinoY = inimigoAlvo.getY();

        } else {
            int[] tmp = m.torreInimigaMaisPerto(this.x, this.y, this.ladoDeSpawn);
            if (tmp != null) {
                this.destinoX = tmp[0];
                this.destinoY = tmp[1];
            } else {
                this.destinoX = -1;
                this.destinoY = -1;
            }
        }
    }

    private void atacarAlvo() {
        if (this.ticks >= 1000 * this.velAtq) {
            if (m.isTorre(this.destinoX, this.destinoY)) {
                m.getTorre(this.destinoX, this.destinoY).tomarDano(this.dano);
            } else {
                this.darDano(m.getEntidadeNoPonto(this.destinoX, this.destinoY));
            } this.ticks = 0;
        }

        this.destinoX = -1;
        this.destinoY = -1;
    }

    public void actionPerformed(ActionEvent e) {

        escolherAlvo();

        if (this.ticks >= lowerBound((int) (1000 / this.velMov))) {

            if (this.destinoX != -1 && this.destinoY != -1) {
                if (getDist(this.x, this.y, this.destinoX, this.destinoY) <= this.alcance) {
                    atacarAlvo();
                }
            }

            if (this.destinoX != -1 && this.destinoY != -1) {
                irPara(this.destinoX, this.destinoY);
                this.ticks = 0;
            }
        } this.ticks += 100;
    } 
}