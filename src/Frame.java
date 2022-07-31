import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(Panel panel){
        super();

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Typing Test");
        this.setLayout(null);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panel);
        this.getContentPane().setPreferredSize(new Dimension(panel.getSize()));
        this.pack();
    }
}