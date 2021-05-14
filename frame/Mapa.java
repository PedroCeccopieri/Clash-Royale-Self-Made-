package frame;

import essenciais.Peca;
import essenciais.entidades.Entidade;
import essenciais.entidades.feitico.Feitico;
import essenciais.ambiente.*;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;
import java.util.List;

public class Mapa extends JPanel implements ActionListener {

    Timer timer;
    
    EventHandler evt;

    final int WIDTH = 12;
    final int HIGHT = 15;
    final int RIO = 7;
    final List<Integer> PONTES = List.of(1,2,9,10);
    final int[][] CORDSTORRES = {{1,2},{5,1},{9,2},{1,11},{5,12},{9,11}};

    ArrayList<Peca> tabuleiro = new ArrayList<Peca>();

    public Mapa(EventHandler evt, Timer timer) {

        this.timer = timer;
        this.timer.addActionListener(this);

        this.evt = evt;

        this.setPreferredSize(new Dimension(384,480));

        inicializarMapa();
        inicializarTorres();

        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
    }

    private double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }

    private void inicializarMapa() {

        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HIGHT; y++) {
                if (y == this.RIO) {
                    if (this.PONTES.contains(x)) tabuleiro.add(new Ponte(x,y));
                    else tabuleiro.add(new Rio(x,y));
                } else {
                    tabuleiro.add(new Chao(x,y));
                }
            }
        }
    }

    private void inicializarTorres() {
        
        for (int[] is : this.CORDSTORRES) {
            tabuleiro.add(new Torre(is[0],is[1]));
        }
    }

    public void addCarta(Peca p) { // adiciona a carta no mapa //
        tabuleiro.add(p);
        repaint();
    }

    private void verificarMortos() { // remove do mapa todas as unidades com a vida < 0 //
        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size(); i++) {
            if (!((tabuleiro.get(i) instanceof Chao) || (tabuleiro.get(i) instanceof Ponte) || (tabuleiro.get(i) instanceof Rio))) {
                if ((!(tabuleiro.get(i) instanceof Torre) && ((Entidade) tabuleiro.get(i)).getVida() <= 0) || ((tabuleiro.get(i) instanceof Torre) && ((Torre) tabuleiro.get(i)).getVida() <= 0)) {
                    if (!(tabuleiro.get(i) instanceof Torre)) ((Entidade) tabuleiro.get(i)).morrer();
                    tabuleiro.remove(i);
                    i--;
                }
            }
        }
    }

    public boolean isTorre(int x, int y) { // verifica se possui uma torre em (x,y) //
        if (getTorre(x,y) != null) return true;
        else return false;
    }

    public Torre getTorre(int x, int y) { // retorna a torre em (x,y) //
        
        int[] cord = {-1,-1};

        for (int i = 0; i < this.CORDSTORRES.length; i++) {
            if (x == this.CORDSTORRES[i][0] && y == this.CORDSTORRES[i][1]) cord = new int[] {this.CORDSTORRES[i][0], this.CORDSTORRES[i][1]};
            else if (x == this.CORDSTORRES[i][0] + 1 && y == this.CORDSTORRES[i][1]) cord = new int[] {this.CORDSTORRES[i][0], this.CORDSTORRES[i][1]};
            else if (x == this.CORDSTORRES[i][0] && y == this.CORDSTORRES[i][1] + 1) cord = new int[] {this.CORDSTORRES[i][0], this.CORDSTORRES[i][1]};
            else if (x == this.CORDSTORRES[i][0] + 1 && y == this.CORDSTORRES[i][1] + 1) cord = new int[] {this.CORDSTORRES[i][0], this.CORDSTORRES[i][1]};
        }

        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size() && (tabuleiro.get(i) instanceof Torre); i++) {
            if (tabuleiro.get(i).getX() == cord[0] && tabuleiro.get(i).getY() == cord[1]) return (Torre) tabuleiro.get(i);
        } return null;
    }

    public int[] torreInimigaMaisPerto(int x, int y, int ladoDeSpawn) { // retorna a torre inimiga mais perto de (x,y) //

        int[] torreEscolhida = null;
        double distancia = -1;

        ArrayList<int[]> torres = new ArrayList<int[]>();

        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size() && (tabuleiro.get(i) instanceof Torre); i++) {
            if (((Torre) tabuleiro.get(i)).ladoDeSpawn != ladoDeSpawn) {
                torres.add(new int[] {tabuleiro.get(i).getX(), tabuleiro.get(i).getY()});
            }
        }

        if (torres.size() > 0) {
            distancia = getDist(x, y, torres.get(0)[0], torres.get(0)[1]);
            torreEscolhida = torres.get(0);
        }

        for (int[] t : torres) {
            if (getDist(x, y, t[0], t[1]) < distancia) {
                distancia = getDist(x, y, t[0], t[1]);
                torreEscolhida = new int[] {t[0], t[1]};
            }
            if (getDist(x, y, t[0] + 1, t[1]) < distancia) {
                distancia = getDist(x, y, t[0] + 1, t[1]);
                torreEscolhida = new int[] {t[0] + 1, t[1]};
            }
            if (getDist(x, y, t[0], t[1] + 1) < distancia) {
                distancia = getDist(x, y, t[0], t[1] + 1);
                torreEscolhida = new int[] {t[0], t[1] + 1};
            }
            if (getDist(x, y, t[0] + 1, t[1] + 1) < distancia) {
                distancia = getDist(x, y, t[0] + 1, t[1] + 1);
                torreEscolhida = new int[] {t[0] + 1, t[1] + 1};
            }
        }

        return torreEscolhida;
    }

    public ArrayList<Entidade> entidadesNaArea(Entidade a, int n) { // retorna as entidades num raio de n a partir da posicao de a //
        
        ArrayList<Entidade> entidades = new ArrayList<Entidade>();
        
        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size(); i++) {
            if (tabuleiro.get(i) != a && !((tabuleiro.get(i) instanceof Torre) || (tabuleiro.get(i) instanceof Chao) || (tabuleiro.get(i) instanceof Ponte) || (tabuleiro.get(i) instanceof Rio) || (tabuleiro.get(i) instanceof Feitico))) {
                Entidade e = (Entidade) tabuleiro.get(i);
                if ((a.getX() - n) <= e.getX() && e.getX() <= (a.getX() + n) && (a.getY() - n) <= e.getY() && e.getY() <= (a.getY() + n) && a.ladoDeSpawn != e.ladoDeSpawn) {
                    entidades.add(e);
                }
            }
        }

        return entidades;
    }

    public Entidade getEntidadeNoPonto(int x, int y) { // retorna a entidade em (x,y) //
        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size(); i++) {
            if (!isTorre(x, y) && tabuleiro.get(i).getX() == x && tabuleiro.get(i).getY() == y) {
                return (Entidade) tabuleiro.get(i);
            }
        } return null;
    }

    public int ponteMaisPerto(int x) { // retorna a posicao x da ponte mais perto da unidade //

        int distanciaAtual, ponteEscolida = 1;
        distanciaAtual = Math.abs(this.PONTES.get(0) - x);

        for (int i = 0; i < 4; i++) {
            int d = Math.abs(this.PONTES.get(i) - x);
            if (d < distanciaAtual) ponteEscolida = i;
        }

        return this.PONTES.get(ponteEscolida);
    }

    public void gameOver() { // verifica o final do jogo //

        boolean t1 = false;
        boolean t2 = false;

        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size() && (tabuleiro.get(i) instanceof Torre); i++) {
            if (this.CORDSTORRES[1][0] == tabuleiro.get(i).getX() && this.CORDSTORRES[1][1] == tabuleiro.get(i).getY()) {
                t1 = true;
                break;
            }
        }

        for (int i = (this.HIGHT * this.WIDTH); i < tabuleiro.size() && (tabuleiro.get(i) instanceof Torre); i++) {
            if (this.CORDSTORRES[4][0] == tabuleiro.get(i).getX() && this.CORDSTORRES[4][1] == tabuleiro.get(i).getY()) {
                t2 = true;
                break;
            }
        }

        if (t1 && !t2) {
            new Fim(0);
            Placar p = new Placar(0);
            p.write();
        }
        if (!t1 && t2) {
            new Fim(1);
            Placar p = new Placar(1);
            p.write();
        }
        if (!(t1 && t2)) this.timer.removeActionListener(this);
    }

    public void paint (Graphics g) {
    	super.paint(g);
        for (int i = 0; i < tabuleiro.size(); i++) {
            tabuleiro.get(i).paint(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        gameOver();
        verificarMortos();
        repaint();
    }



    private class ClickListener extends MouseInputAdapter {
        public void mousePressed (MouseEvent e) {

            if (evt.cartaSelecionadaIsFeitico()) {
                Peca p = evt.SpawnCarta(e.getPoint());
                addCarta(p);
            } else {
               if (e.getY() > 8 * 32) {
                   Peca p = evt.SpawnCarta(e.getPoint());
                   if (p != null) addCarta(p);
               }
            }
        }
    }
}