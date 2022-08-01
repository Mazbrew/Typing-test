import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(Panel panel, Controller cont){
        super();

        this.setResizable(false);
        this.setTitle("Typing Test");
        this.setLayout(null);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panel);
        this.add(cont);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        this.setVisible(true);
    }
}
