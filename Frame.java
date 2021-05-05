import javax.swing.*;

public class Frame extends JFrame {
    
    public Frame(Mapa mapa) {
        
        this.setName("main frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(mapa);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}