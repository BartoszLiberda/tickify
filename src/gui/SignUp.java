package gui;
import javax.swing.*;
import java.awt.*;

public class SignUp extends JPanel {
    

    SignUp(){
        
        setLayout(null);
        setSize(1200, 600);
        setBackground(new Color(0x2F2D49));

        ImageIcon icon = new ImageIcon("tickifylogo.png");
        JLabel banner = new JLabel(icon);
        banner.setLocation(415, 25);
        banner.setSize(400, 80);
        add(banner);

        //first name
        JLabel fnameL = new JLabel("First Name:");
        fnameL.setLocation(450, 138);
        fnameL.setSize(110, 25);

        //define the first name labels font styling and color
        fnameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        fnameL.setForeground(Color.white);

        //define first name field and position
        JTextField fname = new JTextField();
        fname.setLocation(450, 170);
        fname.setSize(300,30);

        //first name field styling and color
        fname.setFont(new Font("Arial", Font.BOLD, 16));
        fname.setBackground(new Color(0x2F2D49));
        fname.setForeground(Color.white);

        //last name
        JLabel lnameL = new JLabel("SurName:");
        lnameL.setLocation(450, 208);
        lnameL.setSize(110, 25);

        //define the last name labels font styling and color
        lnameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        lnameL.setForeground(Color.white);

        //define last name field and position
        JTextField lname = new JTextField();
        lname.setLocation(450, 240);
        lname.setSize(300,30);

        //last name field styling and color
        lname.setFont(new Font("Arial", Font.BOLD, 16));
        lname.setBackground(new Color(0x2F2D49));
        lname.setForeground(Color.white);

        //email
        JLabel emailL = new JLabel("E-mail:");
        emailL.setLocation(450, 278);
        emailL.setSize(110, 25);

        //define the email labels font styling and color
        emailL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        emailL.setForeground(Color.white);

        //define email field and position
        JTextField email = new JTextField();
        email.setLocation(450, 310);
        email.setSize(300,30);

        //email field styling and color
        email.setFont(new Font("Arial", Font.BOLD, 16));
        email.setBackground(new Color(0x2F2D49));
        email.setForeground(Color.white);

        //username

        //define the username label and its positioning
        JLabel unameL = new JLabel("Username:");
        unameL.setLocation(450, 348);
        unameL.setSize(100, 25);

        //define the username labels font styling and color
        unameL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        unameL.setForeground(Color.white);

        //define username field and position
        JTextField uname = new JTextField();
        uname.setLocation(450, 380);
        uname.setSize(300,30);

        //username field styling and color
        uname.setFont(new Font("Arial", Font.BOLD, 16));
        uname.setBackground(new Color(0x2F2D49));
        uname.setForeground(Color.white);

        //password

        //define the password label style and positioning
        JLabel passL = new JLabel("Password:");
        passL.setLocation(450, 418);
        passL.setSize(100, 25);

        passL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 18));
        passL.setForeground(Color.white);

        //define password field style and position
        JPasswordField pass = new JPasswordField();
        pass.setLocation(450, 450);
        pass.setSize(300, 30);

        pass.setBackground(new Color(0x2F2D49));
        pass.setForeground(Color.white);

        //signup button
        JButton signButton = new JButton("Sign Up");
        signButton.setLocation(460, 505);
        signButton.setSize(280, 30);

        //signup button styling and color
        signButton.setFont(new Font("Arial", Font.BOLD, 22));
        signButton.setForeground(Color.white);
        signButton.setBackground(new Color(0x30FF6F));
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
        });

        add(fnameL);
        add(fname);
        add(lnameL);
        add(lname);
        add(emailL);
        add(email);
        add(uname);
        add(unameL);
        add(passL);
        add(pass);
        add(signButton);
    }
}
