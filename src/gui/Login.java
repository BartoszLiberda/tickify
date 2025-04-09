package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
/*
 * WebPage For Colours: https://www.rapidtables.com/web/color/RGB_Color.html
 * Main: White
 * Background: 0x2F2D49
*/
    public Login(MainFrame mainframe) {
        
        setLayout(new GridBagLayout());
        setSize(1200, 600);
        setBackground(new Color(0x2F2D49));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        ImageIcon icon = new ImageIcon("tickifylogo.png");
        JLabel banner = new JLabel(icon);
        add(banner, gbc);

        //username

        //define the username label and its positioning
        JLabel usernameL = new JLabel("Username");
        usernameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        usernameL.setForeground(Color.white);
        gbc.gridy = 1;
        add(usernameL, gbc);

        //define username field and position
        JTextField username = new JTextField(20);
        //username field styling and color
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBackground(new Color(0x2F2D49));
        username.setForeground(Color.white);
        gbc.gridy = 2;
        add(username, gbc);

        //password

        //define the password label style and positioning
        JLabel passwordL = new JLabel("Password");
        passwordL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        passwordL.setForeground(Color.white);
        gbc.gridy = 3;
        add(passwordL, gbc);

        //define password field style and position
        JPasswordField password = new JPasswordField(23);
        password.setBackground(new Color(0x2F2D49));
        password.setForeground(Color.white);
        gbc.gridy = 4;
        add(password, gbc);


        //login button
        JButton LogButton = new JButton("Login");
        //login button styling and color
        LogButton.setFont(new Font("Arial", Font.BOLD, 22));
        LogButton.setForeground(Color.white);
        LogButton.setBackground(new Color(0x30FF6F));
        gbc.gridy = 5;
        add(LogButton, gbc);

        //sign up
        JButton signup = new JButton("Not a User? Sign up..");
        signup.setFont(new Font("Arial", Font.PLAIN, 12));
        signup.setForeground(Color.WHITE);
        signup.setContentAreaFilled(false); //no background
        signup.setBorderPainted(false); //remove border
        gbc.gridy = 6;
        add(signup, gbc);

        LogButton.addActionListener(e -> {
            String enteredUsername = username.getText();
            String enteredPassword = new String(password.getPassword());

            if(isValidLogin(enteredUsername, enteredPassword)){
                // GO TO MAIN PAGE
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                return;
            }
        });

        signup.addActionListener(e ->{
            mainframe.showPanel("signup");
        });
    }
}
