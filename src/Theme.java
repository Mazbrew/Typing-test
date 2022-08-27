import java.awt.Color;

public class Theme {
    private Color bgColor;
    private Color textColor;
    private Color cursorColor;
    private Color timerBarColor;

    public Theme(){
        bgColor = new Color(238,235,226);
        textColor = new Color(153,148,127);
        cursorColor = new Color(140,187,169);
        timerBarColor = new Color(140,187,169);
    }

    public void changeTheme(String colorSet){
        switch (colorSet){
            case "9009":
                bgColor = new Color(238,235,226);
                textColor = new Color(153,148,127);
                cursorColor = new Color(140,187,169);
                timerBarColor = new Color(140,187,169);
                break;
        }
    }

    public Color getBGColor(){
        return bgColor;
    }

    public Color getTextColor(){
        return textColor;
    }

    public Color getCursorColor(){
        return cursorColor;
    }

    public Color getTimerBarColor(){
        return timerBarColor;
    }
}
