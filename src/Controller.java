import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends JPanel implements KeyListener{
    private Panel panel;
    private TimerBar timerBar;
    
    public Controller(Panel panel, TimerBar timerBar) {
        super();

        this.panel = panel;
        this.timerBar = timerBar;

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_F5){
            panel.reset();
            timerBar.resetTimer();
        }
        else if(e.getKeyCode()>=32 && e.getKeyCode()<=126){
            panel.updateCursor();

            if(!timerBar.timerState()){
                timerBar.startTimer();
                timerBar.repaint();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        panel.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
