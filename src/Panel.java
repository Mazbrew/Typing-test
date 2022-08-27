import javax.swing.JPanel;

import java.util.*;

import java.io.File;
import java.awt.*;

public class Panel extends JPanel{
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int)size.getWidth();
    private int height = (int)size.getHeight();

    private int fontSize = 30;

    private Theme theme;

    private Reader reader;

    private String[] displayString = new String[256];
    private Stack<String> stringStack;

    private Font font;

    private int cursorX=0;
    private int cursorY=0;

    public Panel(Theme theme)throws Exception{
        super();

        this.theme = theme;

        reader = new Reader();
        stringStack = reader.generateWords();
        Arrays.fill(displayString,"");

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("font/Hack-Regular.ttf")).deriveFont(Font.PLAIN,fontSize);
        }catch(Exception e){
            System.out.println(e);
        }

        this.setBounds(0,0,width,height);
    }

    protected void reset(){
        try{
            stringStack = reader.generateWords();
            Arrays.fill(displayString,"");
            cursorX = 0;
            cursorY = 0;
            this.repaint();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        paintBG(g);
        paintDisplayString(g);
        paintCursor(g);
    }

    protected void paintBG(Graphics g){
        g.setColor(theme.getBGColor());
        g.fillRect(0, 0, width, height);
    }

    protected void paintDisplayString(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);

        int i = 0;

        while(!stringStack.empty()){
            if(displayString[i].isEmpty()){
                displayString[i] = stringStack.pop();
            }
            if(g2d.getFontMetrics().stringWidth(displayString[i]) >= ((double)width/100.0)*60.0){
                i++;

                if(i == 255){
                    break;
                }

                displayString[i] ="";
                displayString[i] = stringStack.pop();
            }else{
                displayString[i] = displayString[i]+" "+stringStack.pop();
            }    
        }

        g.setColor(theme.getTextColor());

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

        for(i=0;i<256;i++){
            g2d.drawString(displayString[i], (int)(size.getWidth()/2-g2d.getFontMetrics().stringWidth(displayString[i])/2), (i+1)*fontSize);
        }
    }

    protected void paintCursor(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(theme.getCursorColor());
        g.fillRect((cursorX*(int)(g2d.getFontMetrics().stringWidth(" ")))+(int)(size.getWidth()/2-g2d.getFontMetrics().stringWidth(displayString[cursorY])/2), cursorY*fontSize, 2, g2d.getFontMetrics(font).getHeight());
    }

    protected void updateCursor(){
        cursorX++;

        if(cursorX == displayString[cursorY].length()+1){
            cursorY++;
            cursorX=0;
        }
    }
}
