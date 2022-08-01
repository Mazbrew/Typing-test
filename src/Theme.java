import java.awt.Color;

public class Theme {
    private Color bgColor;
    private Color textColor;

    public Theme(){
        bgColor = new Color(238,235,226);
        textColor = new Color(153,148,127);
    }

    public void changeTheme(String colorSet){
        switch (colorSet){
            case "9009":
                bgColor = new Color(238,235,226);
                textColor = new Color(153,148,127);
                break;
        }
    }

    public Color getBGColor(){
        return bgColor;
    }

    public Color getTextColor(){
        return textColor;
    }
}
