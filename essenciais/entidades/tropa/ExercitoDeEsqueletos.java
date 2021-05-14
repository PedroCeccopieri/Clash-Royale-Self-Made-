package essenciais.entidades.tropa;

import frame.Mapa;

import javax.swing.Timer;

public class ExercitoDeEsqueletos extends Tropa {

    public ExercitoDeEsqueletos (int x, int y, int l, Timer t, Mapa m) {
        super(x, y, l, t, m);

        this.vida = 1;

        criarExercito();
    }

    public void criarExercito() {
        for (int i = 0; i < 3; i++) {
            if (this.y + this.ladoDeSpawn == 7) {
                for (int x = this.x - 1; x < this.x + 1; x++) {
                    for (int y = this.y - 1 - this.ladoDeSpawn; y < this.y + 1 - this.ladoDeSpawn; y++) {
                        m.addCarta(new Esqueleto(x , y, this.ladoDeSpawn, t, m));
                    }
                }
            } else {
                for (int x = this.x - 1; x < this.x + 1; x++) {
                    for (int y = this.y - 1; y < this.y + 1; y++) {
                        m.addCarta(new Esqueleto(x , y, this.ladoDeSpawn, t, m));
                    }
                }
            }
        }

        this.vida = 0;
    }
}