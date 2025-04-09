import javax.swing.*;
import java.awt.*;

public class Tickify extends JFrame {
/*
 * WebPage For Colours: https://www.rapidtables.com/web/color/RGB_Color.html
 * Main: White
 * Background: 0x2F2D49
*/
    public Tickify() {
        // Create a new JFrame object
        setTitle("Tickify");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);
        loginpanel.setSize(1200, 600);
        loginpanel.setBackground(new Color(0x2F2D49));

        ImageIcon icon = new ImageIcon("tickifylogo.png");
        JLabel banner = new JLabel(icon);
        banner.setLocation(415, 25);
        banner.setSize(400, 80);
        loginpanel.add(banner);

        //username

        //define the username label and its positioning
        JLabel usernameL = new JLabel("Username:");
        usernameL.setLocation(450, 158);
        usernameL.setSize(100, 25);

        //define the username labels font styling and color
        usernameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        usernameL.setForeground(Color.white);

        //define username field and position
        JTextField username = new JTextField();
        username.setLocation(450, 190);
        username.setSize(300,30);

        //username field styling and color
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBackground(new Color(0x2F2D49));
        username.setForeground(Color.white);

        //password

        //define the password label style and positioning
        JLabel passwordL = new JLabel("Password:");
        passwordL.setLocation(450, 240);
        passwordL.setSize(100, 25);

        passwordL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        passwordL.setForeground(Color.white);

        //define password field style and position
        JPasswordField password = new JPasswordField();
        password.setLocation(450, 272);
        password.setSize(300, 30);

        password.setBackground(new Color(0x2F2D49));
        password.setForeground(Color.white);


        //login button
        JButton LogButton = new JButton("Login");
        LogButton.setLocation(460, 330);
        LogButton.setSize(280, 30);

        //login button styling and color
        LogButton.setFont(new Font("Arial", Font.BOLD, 22));
        LogButton.setForeground(Color.white);
        LogButton.setBackground(new Color(0x30FF6F));

        //sign up
        JButton signup = new JButton("Not a User? Sign up..");
        signup.setFont(new Font("Arial", Font.PLAIN, 12));
        signup.setForeground(Color.WHITE);
        signup.setSize(180, 20);
        signup.setLocation(510, 390);
        signup.setContentAreaFilled(false); //no background
        signup.setBorderPainted(false); //remove border


        //add all components to the login panel
        loginpanel.add(username);
        loginpanel.add(usernameL);
        loginpanel.add(password);
        loginpanel.add(passwordL);
        loginpanel.add(LogButton);
        loginpanel.add(signup);

        add(loginpanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Tickify();
    }
}
