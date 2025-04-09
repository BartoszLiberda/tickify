package gui;

import javax.swing.*;
import java.awt.*;

public class UserTicket extends JFrame {

    UserTicket() {
        setTitle("Tickify");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Ticketpanel = new JPanel();
        Ticketpanel.setLayout(null);
        Ticketpanel.setSize(1200, 600);
        Ticketpanel.setBackground(new Color(0x2F2D49));

        //Label at the top
        JLabel title = new JLabel("Ticket Submission");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.white);
        title.setSize(250, 30);
        title.setLocation(475, 20);

        //row containing First Name and Last Name
        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setLocation(160, 80);
        fnameLabel.setSize(100, 25);
        fnameLabel.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
        fnameLabel.setForeground(Color.white);

        JTextField fnameField = new JTextField();
        fnameField.setLocation(270, 80);
        fnameField.setSize(300, 30);
        fnameField.setForeground(Color.white);
        fnameField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameField.setBackground(new Color(0x2F2D49));

        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setLocation(610, 80);
        lnameLabel.setSize(100, 25);
        lnameLabel.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
        lnameLabel.setForeground(Color.white);

        JTextField lnameField = new JTextField();
        lnameField.setLocation(720, 80);
        lnameField.setSize(300, 30);
        lnameField.setForeground(Color.white);
        lnameField.setFont(new Font("Arial", Font.BOLD, 14));
        lnameField.setBackground(new Color(0x2F2D49));

        // Second Row holds the Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setSize(100, 25);
        emailLabel.setLocation(160, 130);
        emailLabel.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
        emailLabel.setForeground(Color.white);

        JTextField emailField = new JTextField();
        emailField.setSize(300, 30);
        emailField.setLocation(270, 130);
        emailField.setForeground(Color.white);
        emailField.setFont(new Font("Arial", Font.BOLD, 14));
        emailField.setBackground(new Color(0x2F2D49));

        //third Row
        JLabel descL = new JLabel("Issue Description:");
        descL.setSize(150, 25);
        descL.setLocation(160, 180);
        descL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
        descL.setForeground(Color.white);

        JTextArea descField = new JTextArea();
        descField.setSize(860, 250);
        descField.setLocation(160, 210);
        descField.setLineWrap(true);
        descField.setWrapStyleWord(true);
        descField.setBackground(Color.white);
        descField.setForeground(new Color(0x2F2D49));
        descField.setFont(new Font("Arial", Font.BOLD, 15));

        //reset and submit
        //submit button
        JButton submitB = new JButton("Submit");
        submitB.setLocation(160, 490);
        submitB.setSize(120, 30);

        //submit button styling and color
        submitB.setFont(new Font("Arial", Font.BOLD, 20));
        submitB.setForeground(Color.white);
        submitB.setBackground(new Color(0x30FF6F));

        //reset button
        JButton resetB = new JButton("Reset");
        resetB.setLocation(300, 490);
        resetB.setSize(120, 30);

        //reset button styling and color
        resetB.setFont(new Font("Arial", Font.BOLD, 20));
        resetB.setForeground(Color.white);
        resetB.setBackground(new Color(0xd41f2d));

        //event listeners
        resetB.addActionListener(e -> {
            // Clear all text fields and the text area
            fnameField.setText("");
            lnameField.setText("");
            emailField.setText("");
            descField.setText("");
        });

        submitB.addActionListener(e -> {
            String fname = fnameField.getText();
            String lname = lnameField.getText();
            String email = emailField.getText();

            if (fname.matches(".*[^a-zA-Z ].*") || lname.matches(".*[^a-zA-Z ].*")) {
                JOptionPane.showMessageDialog(null, "Names can't contain symbols or letters!");
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(null, "Email must contain '@' and '.'");
                return;
            }
        });


        // Add components to the panel
        Ticketpanel.add(title);Ticketpanel.add(fnameLabel);Ticketpanel.add(fnameField);Ticketpanel.add(lnameLabel);
        Ticketpanel.add(lnameField);Ticketpanel.add(emailLabel);Ticketpanel.add(emailField);Ticketpanel.add(resetB);
        Ticketpanel.add(descL);Ticketpanel.add(descField);Ticketpanel.add(submitB);
        

        // Add the panel to the frame
        add(Ticketpanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserTicket();
    }
}



