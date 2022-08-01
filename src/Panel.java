import javax.swing.JPanel;

import java.util.*;

import java.io.File;
import java.awt.*;


public class Panel extends JPanel{
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int)size.getWidth();
    private int height = (int)size.getHeight();

    private int fontSize = 30;

    private Theme theme = new Theme();

    private Reader reader;

    private String[] displayString = new String[256];
    private Stack<String> stringStack;

    public Panel()throws Exception{
        super();

        reader = new Reader();
        stringStack = reader.generateWords();
        Arrays.fill(displayString,"");

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
        Graphics2D g2d = (Graphics2D) g;
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font/Hack-Regular.ttf")).deriveFont(Font.PLAIN,fontSize);
            g2d.setFont(font);
        }catch(Exception e){
            System.out.println(e);
        }

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
                System.out.println(i);
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
}
