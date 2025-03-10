import javax.swing.JFrame;
import gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(700,700);
        login.setVisible(true);
        login.setLocation(500,400);
    }
}
