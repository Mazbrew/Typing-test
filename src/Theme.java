import java.awt.Color;

public class Theme {
    private Color bgColor;

    public Theme(){
        bgColor = new Color(238,235,226);
    }

    public void changeTheme(String colorSet){
        switch (colorSet){
            case "9009":
                bgColor = new Color(238,235,226);
                break;
        }
    }

    public Color getBGColor(){
        return bgColor;
    }
}
