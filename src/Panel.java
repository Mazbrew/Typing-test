import java.awt.Graphics;

import javax.swing.JPanel;

import java.util.*;

import java.awt.Font;
import java.io.File;
import java.awt.Graphics2D;

public class Panel extends JPanel{
    private int sizeInstance = 40;
    private int width = 16 * sizeInstance;
    private int height = 9 * sizeInstance;

    private Theme theme = new Theme();

    private Reader reader;

    private String displayString="";
    private Stack<String> stringStack;

    public Panel()throws Exception{
        super();

        reader = new Reader();
        stringStack = reader.generateWords();

        this.setBounds(0,0,width,height);
    }

    @Override
    protected void paintComponent(Graphics g){
        paintBG(g);
        paintDisplayString(g);
    }

    protected void paintBG(Graphics g){
        g.setColor(theme.getBGColor());
        g.fillRect(0, 0, width, height);
    }

    protected void paintDisplayString(Graphics g){
        while(!stringStack.empty()){
            displayString = displayString+" "+stringStack.pop();
        }
        g.setColor(theme.getTextColor());

        Graphics2D g2d = (Graphics2D) g;
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font/Hack-Regular.ttf")).deriveFont(Font.PLAIN,20f);
            g2d.setFont(font);
        }catch(Exception e){
            System.out.println(e);
        }

        g2d.drawString(displayString, 0,20);
    }
}
