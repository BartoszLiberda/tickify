package gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import model.User;
import model.Ticket;
import dao.db;

public class MainMenu extends JPanel {

    db db = new db();

    private int userID;
    private String userType;

    private List<Ticket> userTickets;

    public void saveUser(User user){
        userID = user.getId();
        userType = user.getType();
    }

    MainMenu(MainFrame mainFrame){
        
        setLayout(new GridBagLayout());
        setSize(1200, 600);

        JPanel leftPanel = new JPanel(new GridLayout(5, 1)); //grid set up layout for side nav space
        leftPanel.setBackground(new Color(0x242334));
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0x2F2D49));
        rightPanel.setLayout(new GridBagLayout());

        //adds image
        ImageIcon icon = new ImageIcon("smaller.png");
        JLabel banner = new JLabel(icon, SwingConstants.CENTER);
        banner.setSize(new Dimension(100, 100));
        leftPanel.add(banner);

        //buttons for assigning, viewing, closing and creating tickets
        JButton vTickets = new JButton("View Tickets");
        vTickets.setBorder(BorderFactory.createEmptyBorder());
        vTickets.setFocusPainted(false);
        vTickets.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
        vTickets.setForeground(Color.white);
        vTickets.setBackground(new Color(0x242334));

        JButton cTickets = new JButton("Create Ticket");
        cTickets.setBorder(BorderFactory.createEmptyBorder());
        cTickets.setFocusPainted(false);
        cTickets.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
        cTickets.setForeground(Color.white);
        cTickets.setBackground(new Color(0x242334));

        JButton aTickets = new JButton("Assign Tickets");
        aTickets.setBorder(BorderFactory.createEmptyBorder());
        aTickets.setFocusPainted(false);
        aTickets.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
        aTickets.setForeground(Color.white);
        aTickets.setBackground(new Color(0x242334));

        JButton clTickets = new JButton("Close Tickets");
        clTickets.setBorder(BorderFactory.createEmptyBorder());
        clTickets.setFocusPainted(false);
        clTickets.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
        clTickets.setForeground(Color.white);
        clTickets.setBackground(new Color(0x242334));

        // Add buttons to the left panel
        leftPanel.add(vTickets);
        leftPanel.add(cTickets);
        leftPanel.add(aTickets);
        leftPanel.add(clTickets);


        //add everything to the main panel
        GridBagConstraints mainsplitgbc = new GridBagConstraints();
        mainsplitgbc.fill = GridBagConstraints.BOTH;
        mainsplitgbc.gridy = 0;

        // Left panel 20%
        mainsplitgbc.gridx = 0;
        mainsplitgbc.weightx = 0.2;
        mainsplitgbc.weighty = 1.0;
        add(leftPanel, mainsplitgbc);

        // Right panel 80%
        mainsplitgbc.gridx = 1;
        mainsplitgbc.weightx = 0.8;
        mainsplitgbc.weighty = 1.0;
        add(rightPanel, mainsplitgbc);


        //event listeners
        vTickets.addActionListener(e -> {
            rightPanel.removeAll();
            if("u".equals(userType)){
                userTickets = db.getUserTickets(userID);
                if(userTickets.isEmpty()){
                    rightPanel.setLayout(new GridBagLayout());
                    JLabel ntheader = new JLabel("You Currently Have No Tickets");
                    ntheader.setFont(new Font("Arial", Font.BOLD, 20));
                    ntheader.setForeground(Color.white);
                    GridBagConstraints ntgbc = new GridBagConstraints();
                    ntgbc.gridx = 0;
                    ntgbc.gridy = 0;
                    ntgbc.anchor = GridBagConstraints.CENTER;
                    rightPanel.add(ntheader,ntgbc);
                    ntgbc.gridy = 1;
                    JButton createredirect = new JButton("Create Ticket");
                    createredirect.setPreferredSize(new Dimension(160, 30));
                    createredirect.setFont(new Font("Arial", Font.BOLD, 20));
                    createredirect.setForeground(Color.white);
                    createredirect.setFocusPainted(false);
                    createredirect.setBackground(new Color(0x3B0054));
                    rightPanel.add(createredirect,ntgbc);
                        // update the panel
                    rightPanel.revalidate();
                    rightPanel.repaint();
    
                    //listener
                    createredirect.addActionListener(w -> {
                        cTickets.doClick();
                    });
                }
                else{
                    rightPanel.setLayout(new GridBagLayout());
                    JLabel ntheader = new JLabel("You Have Tickets");
                    ntheader.setFont(new Font("Arial", Font.BOLD, 20));
                    ntheader.setForeground(Color.white);
                    GridBagConstraints ntgbc = new GridBagConstraints();
                    ntgbc.gridx = 0;
                    ntgbc.gridy = 0;
                    ntgbc.anchor = GridBagConstraints.CENTER;
                    rightPanel.add(ntheader,ntgbc);
                    ntgbc.gridy = 1;
                    JButton createredirect = new JButton("Create Ticket");
                    createredirect.setPreferredSize(new Dimension(160, 30));
                    createredirect.setFont(new Font("Arial", Font.BOLD, 20));
                    createredirect.setForeground(Color.white);
                    createredirect.setFocusPainted(false);
                    createredirect.setBackground(new Color(0x3B0054));
                    rightPanel.add(createredirect,ntgbc);
                        // update the panel
                    rightPanel.revalidate();
                    rightPanel.repaint();
    
                    //listener
                    createredirect.addActionListener(w -> {
                        cTickets.doClick();
                    });
                }
            }
        });
        cTickets.addActionListener(e -> {
            // Remove all previous components
            rightPanel.removeAll();
            rightPanel.setLayout(new GridLayout(5, 2, 10, 50)); //layout setup
            
            // Create and add the header label
            JLabel header1 = new JLabel("Ticket", SwingConstants.RIGHT);
            header1.setFont(new Font("Arial", Font.BOLD, 24));
            header1.setForeground(Color.white);
            rightPanel.add(header1);
            JLabel header2 = new JLabel("Submission",SwingConstants.LEFT);
            header2.setFont(new Font("Arial", Font.BOLD, 24));
            header2.setForeground(Color.white);
            rightPanel.add(header2);
            
            //add the title text field beside the title label
            JPanel titlepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlepanel.setBackground(new Color(0x2F2D49));
            JTextField titlef = new JTextField();
            titlef.setForeground(Color.white);
            titlef.setFont(new Font("Arial", Font.BOLD, 14));
            titlef.setPreferredSize(new Dimension(200, 30));
            titlef.setBackground(new Color(0x2F2D49));
            JLabel titleL = new JLabel("Title:", SwingConstants.CENTER);
            titleL.setPreferredSize(new Dimension(200, 30));
            titleL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
            titleL.setForeground(Color.white);
            titlepanel.add(titleL);
            titlepanel.add(titlef);
            rightPanel.add(titlepanel);

            //add the email text field beside the email label
            JPanel emailpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            emailpanel.setBackground(new Color(0x2F2D49));
            JLabel emailLabel = new JLabel("Email:",SwingConstants.CENTER);
            emailLabel.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
            emailLabel.setForeground(Color.white);
            emailLabel.setPreferredSize(new Dimension(200, 30));
            JTextField emailField = new JTextField();
            emailField.setForeground(Color.white);
            emailField.setFont(new Font("Arial", Font.BOLD, 14));
            emailField.setBackground(new Color(0x2F2D49));
            emailField.setPreferredSize(new Dimension(200, 30));
            emailpanel.add(emailLabel);
            emailpanel.add(emailField);
            rightPanel.add(emailpanel);
            
            JPanel desctitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
            desctitle.setBackground(new Color(0x2F2D49));
            JLabel descL = new JLabel("Issue Description:",SwingConstants.RIGHT);
            descL.setPreferredSize(new Dimension(200, 30));
            descL.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 14));
            descL.setForeground(Color.white);
            JPanel descfield = new JPanel(new FlowLayout(FlowLayout.LEFT));
            descfield.setBackground(new Color(0x2F2D49));
            JTextArea descField = new JTextArea();
            descField.setPreferredSize(new Dimension(405, 250));
            descField.setLineWrap(true);
            descField.setWrapStyleWord(true);
            descField.setBackground(Color.white);
            descField.setForeground(new Color(0x2F2D49));
            descField.setFont(new Font("Arial", Font.BOLD, 15));
            desctitle.add(descL);
            descfield.add(descField);
            rightPanel.add(desctitle);
            rightPanel.add(descfield);
            rightPanel.add(new JLabel(""));
            JPanel buttonspanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonspanel.setBackground(new Color(0x2F2D49));
            JButton submitB = new JButton("Submit");
            submitB.setPreferredSize(new Dimension(120, 30));
            submitB.setFont(new Font("Arial", Font.BOLD, 20));
            submitB.setForeground(Color.white);
            submitB.setBackground(new Color(0x30FF6F));
            JButton resetB = new JButton("Reset");
            resetB.setPreferredSize(new Dimension(120, 30));
            resetB.setFont(new Font("Arial", Font.BOLD, 20));
            resetB.setForeground(Color.white);
            resetB.setBackground(new Color(0xd41f2d));
            buttonspanel.add(submitB);
            buttonspanel.add(resetB);
            rightPanel.add(buttonspanel);


            //listeners
            resetB.addActionListener(f -> {
                // Clear all text fields and the text area
                titlef.setText("");
                emailField.setText("");
                descField.setText("");
            });

            submitB.addActionListener(f -> {
                String title = titlef.getText();
                String email = emailField.getText();

                if (title.matches(".*[^a-zA-Z ].*")) {
                    JOptionPane.showMessageDialog(null, "Names can't contain symbols!");
                    return;
                }
                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(null, "Email must contain '@' and '.'");
                    return;
                }
        });

        // update the panel
        rightPanel.revalidate();
        rightPanel.repaint();
        });
    }
}
