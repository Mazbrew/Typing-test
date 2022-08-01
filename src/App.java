public class App {
    public static void main(String[] args) throws Exception {
        Panel panel = new Panel();
        Controller cont = new Controller();
        new Frame(panel,cont);
    }
}
