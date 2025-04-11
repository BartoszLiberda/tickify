package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel cards;

    public MainFrame(){
        setTitle("Tickify");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        SignUp signupPanel = new SignUp(this);
        MainMenu mainMenuPanel = new MainMenu(this);
        Login loginPanel = new Login(this, mainMenuPanel);

        cards.add(loginPanel, "login");
        cards.add(signupPanel, "signup");
        cards.add(mainMenuPanel, "mainmenu");

        add(cards);
        setVisible(true);
    }

    public void showPanel(String name){
        cardLayout.show(cards, name);
    }
}
