package frame;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import essenciais.cartas.tropa.*;
import essenciais.cartas.construcao.*;
import essenciais.cartas.feitico.*;
import essenciais.cartas.Carta;


public class Mao extends JPanel {

    EventHandler evt;

    ArrayList<Carta> cartas = new ArrayList<Carta>(4);
    ArrayList<Point> posDaMao = new ArrayList<Point>(4);
    ArrayList<Boolean> posCartasNaMao = new ArrayList<Boolean>(4);

    Carta selecionada = null;
    Image selecao = new ImageIcon("./sprites/cartas/selecionada.png").getImage();

    Point pointClicked;

    Random rand = new Random();
    
    public Mao(EventHandler evt) {

        this.evt = evt;

        inicializarMao();

        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);

        this.setPreferredSize(new Dimension(384,116));
        this.setLayout(null);

        encherMao();

        this.setVisible(true);
    }

    private void addCarta(Carta c) {
        for (boolean pos : posCartasNaMao) {
            if (!pos) {
                int index = posCartasNaMao.indexOf(pos);
                Point p = posDaMao.get(index);
                c.setpos((int) p.getX(), (int) p.getY());
                posCartasNaMao.set(index, true);
                cartas.set(index, c);
                break;
            }
        }
    }

    private void inicializarMao() {
        posDaMao.add(new Point(0,0));
        posDaMao.add(new Point(96,0));
        posDaMao.add(new Point(192,0));
        posDaMao.add(new Point(288,0));

        for (int i = 0; i < 4; i++) posCartasNaMao.add(false);

        for (int i = 0; i < 4; i++) cartas.add(null);
    }

    private Carta whichCarta(int x, int y) {
        Carta aux = null;
        for (int i = 0; i < cartas.size(); i++) {
            Carta c = cartas.get(i);
            if (c.getX() < pointClicked.getX() && pointClicked.getX() < c.getX() + c.getW() && c.getY() < pointClicked.getY() && pointClicked.getY() < c.getY() + c.getH()) {
                aux = c;
            }
        } return aux;
    }

    public void excluirCarta(Carta e) {
        for (Carta c : cartas) {
            if (e == c) {
                int index = cartas.indexOf(e);
                cartas.set(index, null);
                posCartasNaMao.set(index, false);
                selecionada = null;
                break;
            }
        }

        evt.setCartaSelecionada(null);

        encherMao();
        repaint();
    }

    private boolean temNaMao(int n) {

        int carta = -1;
        for (Carta c : cartas) {
            if (c instanceof CartaCavaleiro) carta = 0;
            if (c instanceof CartaArqueira) carta = 1;
            if (c instanceof CartaGigante) carta = 2;
            if (c instanceof CartaMago) carta = 3;
            if (c instanceof CartaExercitoDeEsqueletos) carta = 4;
            if (c instanceof CartaEsqueletoBomba) carta = 5;
            if (c instanceof CartaBolaDeFogo) carta = 6;
            if (c instanceof CartaXBesta) carta = 7;

            if (carta == n) return true;
        } return false;
    }

    private void encherMao() {

        while (!(posCartasNaMao.get(0) && posCartasNaMao.get(1) && posCartasNaMao.get(2) && posCartasNaMao.get(3))) {

            for (int i = 0; i < 4; i++) {
                int r1 = rand.nextInt(8);

                if (!posCartasNaMao.get(i)) {
                    switch (r1) {
                        case 0:
                            if (!temNaMao(0)) this.addCarta(new CartaCavaleiro());
                            break;
                        case 1:
                            if (!temNaMao(1)) this.addCarta(new CartaArqueira());
                            break;
                        case 2:
                            if (!temNaMao(2)) this.addCarta(new CartaGigante());
                            break;
                        case 3:
                            if (!temNaMao(3)) this.addCarta(new CartaMago());
                            break;
                        case 4:
                            if (!temNaMao(4)) this.addCarta(new CartaExercitoDeEsqueletos());
                            break;
                        case 5:
                            if (!temNaMao(5)) this.addCarta(new CartaEsqueletoBomba());
                            break;
                        /*case 6:
                            if (!temNaMao(6)) this.addCarta(new CartaBolaDeFogo());
                            break;
                        case 7:
                            if (!temNaMao(7)) this.addCarta(new CartaXBesta());
                            break;*/
                    }
                }
            }
        }
    }

    public void paint (Graphics g) {
    	super.paint(g);

        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).paint(g);
        }

        if (selecionada != null) g.drawImage(selecao, selecionada.getX(), selecionada.getY(), null);
    }



    private class ClickListener extends MouseInputAdapter {
        public void mousePressed (MouseEvent e) {
            pointClicked = e.getPoint();

            Carta c = whichCarta(e.getX(), e.getY());

            if (c != null) {
                selecionada = c;
                evt.setCartaSelecionada(c);
            } repaint();
        }
    }
}