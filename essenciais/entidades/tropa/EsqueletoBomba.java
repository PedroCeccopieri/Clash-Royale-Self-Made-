package essenciais.entidades.tropa;

import frame.Mapa;

import essenciais.entidades.Entidade;
import essenciais.entidades.construcao.Construcao;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.util.ArrayList;

public class EsqueletoBomba extends Tropa {

    public EsqueletoBomba (int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);

        this.vida = 32;
        this.dano = 450;
        this.alcance = 1;
        this.velAtq = 1.0;
        this.velMov = 2.0;

        this.w = 32;
        this.h = 32;

        this.sprite = new ImageIcon("./sprites/tropa/esqueletobomba32.png").getImage();
    }

    protected void escolherAlvo() {

        ArrayList<Entidade> entidades = m.entidadesNaArea(this, 3);

        if (entidades.size() > 0) {

            Entidade inimigoAlvo = null;
            double dist = -1;

            for (int i = 0; i < entidades.size(); i++) {
                if (entidades.get(i) instanceof Construcao) {
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
            }

            if (inimigoAlvo != null) {
                this.destinoX = inimigoAlvo.getX();
                this.destinoY = inimigoAlvo.getY();
                return;
            }
        }

        int[] tmp = m.torreInimigaMaisPerto(this.x, this.y, this.ladoDeSpawn);
        if (tmp != null) {
            this.destinoX = tmp[0];
            this.destinoY = tmp[1];
        } else {
            this.destinoX = -1;
            this.destinoY = -1;
        }
    }

    protected void atacarAlvo() {
        if (this.ticks >= 1000 * this.velAtq) {
            if (m.isTorre(this.destinoX, this.destinoY)) {
                m.getTorre(this.destinoX, this.destinoY).tomarDano(this.dano);
            } else {
                this.darDano(m.getEntidadeNoPonto(this.destinoX, this.destinoY));
            } explodir();
        }
    }

    private void explodir() {
        this.vida -= this.dano;
    }
}