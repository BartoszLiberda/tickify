package gui;

import javax.swing.*;
import java.awt.*;

import dao.db;

public class SignUp extends JPanel {

    private MainFrame mainFrame;

    SignUp(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        db db = new db();

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

        //first name

        JLabel fnameL = new JLabel("First Name");
        //define the first name labels font styling and color
        fnameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        fnameL.setForeground(Color.white);
        gbc.gridy = 1;
        add(fnameL, gbc);

        //define first name field and position
        JTextField fname = new JTextField(20);
        //first name field styling and color
        fname.setFont(new Font("Arial", Font.BOLD, 16));
        fname.setBackground(new Color(0x2F2D49));
        fname.setForeground(Color.white);
        gbc.gridy = 2;
        add(fname, gbc);

        //last name

        JLabel lnameL = new JLabel("Surname");
        //define the last name labels font styling and color
        lnameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        lnameL.setForeground(Color.white);
        gbc.gridy = 3;
        add(lnameL, gbc);

        //define last name field and position
        JTextField lname = new JTextField(20);
        //last name field styling and color
        lname.setFont(new Font("Arial", Font.BOLD, 16));
        lname.setBackground(new Color(0x2F2D49));
        lname.setForeground(Color.white);
        gbc.gridy = 4;
        add(lname, gbc);

        //email

        JLabel emailL = new JLabel("E-mail");
        //define the email labels font styling and color
        emailL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        emailL.setForeground(Color.white);
        gbc.gridy = 5;
        add(emailL, gbc);

        JTextField email = new JTextField(20);
        //email field styling and color
        email.setFont(new Font("Arial", Font.BOLD, 16));
        email.setBackground(new Color(0x2F2D49));
        email.setForeground(Color.white);
        gbc.gridy = 6;
        add(email, gbc);

        //username

        //define the username label and its positioning
        JLabel unameL = new JLabel("Username");
        //define the username labels font styling and color
        unameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        unameL.setForeground(Color.white);
        gbc.gridy = 7;
        add(unameL, gbc);
        
        JTextField uname = new JTextField(20);
        //username field styling and color
        uname.setFont(new Font("Arial", Font.BOLD, 16));
        uname.setBackground(new Color(0x2F2D49));
        uname.setForeground(Color.white);
        gbc.gridy = 8;
        add(uname, gbc);

        //password

        //define the password label style and positioning
        JLabel passL = new JLabel("Password");
        passL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        passL.setForeground(Color.white);
        gbc.gridy = 9;
        add(passL, gbc);

        //define password field style and position
        JPasswordField pass = new JPasswordField(23);
        pass.setBackground(new Color(0x2F2D49));
        pass.setForeground(Color.white);
        gbc.gridy = 10;
        add(pass, gbc);

        //signup button
        JButton signButton = new JButton("Sign Up");
        //signup button styling and color
        signButton.setFont(new Font("Arial", Font.BOLD, 22));
        signButton.setForeground(Color.white);
        signButton.setBackground(new Color(0x30FF6F));
        gbc.gridy = 11;
        add(signButton, gbc);
        //event listener
        signButton.addActionListener(e -> {
            String firstName = fname.getText();
            String lastName = lname.getText();
            String emailText = email.getText();
            String username = uname.getText();
            String password = new String(pass.getPassword());

            if (firstName.matches(".*[^a-zA-Z ].*") || lastName.matches(".*[^a-zA-Z ].*")) {
                JOptionPane.showMessageDialog(null, "Names can't contain symbols or letters!");
                return;
            }
            if (!emailText.contains("@") || !emailText.contains(".")) {
                JOptionPane.showMessageDialog(null, "Email must contain '@' and '.'");
                return;
            }
            if (username.length() > 12) {
                JOptionPane.showMessageDialog(null, "Username must be under 12 characters long!");
                return;
            }
            if (username.matches(".*[^a-zA-Z ].*") || username.matches(".*[^a-zA-Z ].*")) {
                JOptionPane.showMessageDialog(null, "Username can't contain symbols or letters!");
                return;
            }
            if (password.length() < 8 || password.length() > 12) {
                JOptionPane.showMessageDialog(null, "Password must be between 8 and 12 characters long!");
                return;
            }
            else{
                db.newUser(firstName,lastName,emailText,username,password);
                mainFrame.showPanel("login");
            }
        });
    }
}
