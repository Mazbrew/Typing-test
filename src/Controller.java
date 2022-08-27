import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends JPanel implements KeyListener{
    private Panel panel;
    
    public Controller(Panel panel) {
        super();

        this.panel = panel;

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode()>=32 && e.getKeyCode()<=126){
            panel.updateCursor();
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F5){
            panel.reset();
        }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        panel.repaint();
    }
}
