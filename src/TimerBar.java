import javax.swing.JPanel;

import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;

public class TimerBar extends JPanel{

    private Theme theme;
    private Panel panel;

    private Timer timer;

    private double duration;
    private double fullDuration;

    // false for stop , true for start
    private boolean state = false;

    public TimerBar(Panel panel,Theme theme, double duration){
        this.panel = panel;
        this.theme = theme;
        this.duration = duration;
        this.fullDuration = duration;
        

        this.setBounds(0,0,panel.getWidth(),panel.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(theme.getBGColor());
        g.fillRect(0, 0,(int)(panel.getWidth()), panel.getHeight()/100);
        g.setColor(theme.getTimerBarColor());
        g.fillRect(0, 0,(int)(panel.getWidth() * duration/fullDuration), panel.getHeight()/100);
    }

    private void countdown(){
        duration--;
        repaint();
    }

    public void startTimer(){
        state = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                countdown();
            }
        }, 0, 1);
    }

    public boolean timerState(){
        return state;
    }

    public void resetTimer(){
        state = false;
        duration = fullDuration;
        repaint();
        timer.cancel();
        timer.purge();
    }
}
