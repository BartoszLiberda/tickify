package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing. JTextField ;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Login extends JFrame{
    private JTextField Username;
    private JPasswordField Password;
    private JButton Loginbutton;

    public class LoginHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            String string = "";
            if(event.getSource()==Username)
            {
                string = String.format("Username : %s",
                event.getActionCommand());
            }
            else if(event.getSource()==Password)
            {
                string = String.format("Password: %s",
                event.getActionCommand());
            }
            else if(event.getSource()==Loginbutton)
            {
            }


            JOptionPane.showMessageDialog( null, string );
            }
    
    }

public Login(){
    super( "Tickify");
    setLayout(new FlowLayout());
    JLabel icon = new JLabel("");
    Icon icon_img = new ImageIcon(this.getClass().getResource("ticket.png"));
    icon.setIcon(icon_img);
    add(icon);
    Username = new JTextField(25);
    Username.setHorizontalAlignment(JTextField.CENTER);
    add(Username);
    Password = new JPasswordField(25);
    Password.setHorizontalAlignment(JTextField.CENTER);
    add(Username);
    add(Password);
    Loginbutton = new JButton("Login");
    add(Loginbutton);

    LoginHandler handler = new LoginHandler();
    Username.addActionListener(handler);
    Password.addActionListener(handler);
    Loginbutton.addActionListener(handler);
    }
} 

    