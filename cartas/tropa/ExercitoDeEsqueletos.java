package cartas.tropa;

import java.util.ArrayList;

public class ExercitoDeEsqueletos extends Esqueleto {

    private int quantidade;
    private ArrayList<Esqueleto> esqueletos = new ArrayList<Esqueleto>();

    public ExercitoDeEsqueletos () {
        this.custo = 3;
        this.quantidade = 15;
    }

    public void criarExercito() {
        for (int i = 0; i < quantidade; i++) {
            Esqueleto e = new Esqueleto();
            esqueletos.add(e);
        }
    }

    @Override
    public void spawn(int x, int y) {
        this.criarExercito();
        for (Esqueleto esq : this.esqueletos) {
            esq.spawn(x,y);
        }
    }
}