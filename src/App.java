public class App {
    public static void main(String[] args) throws Exception {
        double duration = 60000;

        Theme theme = new Theme();
        Panel panel = new Panel(theme);
        TimerBar timerBar = new TimerBar(panel, theme, duration);
        Controller cont = new Controller(panel, timerBar);
        new Frame(panel,cont,timerBar);
    }
}
