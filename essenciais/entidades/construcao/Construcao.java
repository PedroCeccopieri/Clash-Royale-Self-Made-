package essenciais.entidades.construcao;

import frame.Mapa;

import essenciais.entidades.Entidade;

import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Math;

import java.util.ArrayList;

public abstract class Construcao extends Entidade implements ActionListener {

    protected int alcance;
    protected double velAtq;

    private int alvoX = -1;
    private int alvoY = -1;

    public Construcao(int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);
    }

    private double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }

    private void escolherAlvo() { // escolhe o alvo mais proximo // 

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

            this.alvoX = inimigoAlvo.getX();
            this.alvoY = inimigoAlvo.getY();
        } else {
            this.alvoX = -1;
            this.alvoY = -1;
        }
    }

    private void atacarAlvo() { // ataca o alvo escolhido //
        this.darDano(m.getEntidadeNoPonto(this.alvoX, this.alvoY));
    }

    public void actionPerformed(ActionEvent e) {

        escolherAlvo();

        if (this.ticks >= 1000 * this.velAtq) {
            if (alvoX != -1 && alvoY != -1) {
                if (getDist(this.x, this.y, this.alvoX, this.alvoY) <= this.alcance) {
                    atacarAlvo();
                    this.ticks = 0;
                }
            }
        } this.ticks += 100;
    }
}