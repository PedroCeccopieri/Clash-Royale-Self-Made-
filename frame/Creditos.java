package frame;

import java.awt.*;

import javax.swing.JTextPane;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class Creditos extends JFrame {
    
    private JTextPane texto;
    private JTextPane nomes;

    public Creditos() {
        
        this.setName("creditos");
        this.setPreferredSize(new Dimension(384,480));
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        this.texto = new JTextPane();
        this.texto.setText("O jogo se da por um confronto 1 contra 1 tendo um outro jogador como adversario, Os jogadores recebem 4 cartas dentre as varias existentes no jogo e partir dai, produzem uma batalha. Cada jogador tem 3 torres, o objetivo do jogador e destruir a torre principal do adversario, caracterizando assim, o fim do jogo, entretanto, se dentro do tempo estabelecido, nenhum jogador tiver destruido a torre principal do inimigo, o vencedor e o jogador que tiver destruido mais torres durante a partida.");
        this.texto.setPreferredSize(new Dimension(192,280));
        this.texto.setEditable(false);

        this.nomes = new JTextPane();

        this.nomes.setText("Caio Nogueira \n Elle Pedrosa \n Walmir Machado");
        this.nomes.setPreferredSize(new Dimension(192,60));
        this.nomes.setEditable(false);
        
        this.add(texto);
        this.add(nomes);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
    

