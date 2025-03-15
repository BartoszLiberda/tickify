// TODO
// - Add Sign Up Button + Function
// - Add Logo
// - Add Login Functions

package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.SwingConstants;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;


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
    setLayout(new GridBagLayout());
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS)); 
    loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    // Username input
    Username = new JTextField(20);
    loginPanel.add(createLabeledPanel("Username:", Username));

    // Password input
    Password = new JPasswordField(20);
    loginPanel.add(createLabeledPanel("Password:", Password));

    // Login button
    Loginbutton = new JButton("Login");
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(Loginbutton);
    loginPanel.add(buttonPanel);

    // Add the login panel to the center
    add(loginPanel, new GridBagConstraints());

    // Event handling
    Loginbutton.addActionListener(new LoginHandler());

    // Window settings
    setSize(1200, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // Centers the entire window
    }

    private JPanel createLabeledPanel(String label, JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel(label));
        panel.add(component);
        return panel;
    }
} 