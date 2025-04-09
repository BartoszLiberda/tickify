import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Ticket;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        JPanel cardPanel = new JPanel(new CardLayout());

        JPanel login = new JPanel(); // edit this 
        JPanel signup = new JPanel(); // this too 

        cardPanel.add(login, "login");
        cardPanel.add(signup, "sign up")

        frame.add(cardPanel);
        frame.setVisible(true);
    }
}
