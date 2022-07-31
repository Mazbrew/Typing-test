import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
    private int sizeInstance = 40;
    private int width = 16 * sizeInstance;
    private int height = 9 * sizeInstance;

    private Theme theme = new Theme();

    public Panel(){
        super();

        
        this.setBounds(0,0,width,height);
    }

    @Override
    protected void paintComponent(Graphics g){
        paintBG(g);
    }

    protected void paintBG(Graphics g){
        g.setColor(theme.getBGColor());
        g.fillRect(0, 0, width, height);
    }
}
