import javax.swing.*;
import java.awt.*;

public class SampleTicket extends JPanel {

    public SampleTicket(String title, int ticketId, String[] assignees) {
        setLayout(null);
        setBackground(new Color(0x3E3C5E));
        setPreferredSize(new Dimension(300, 200));
        //needs a location
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JLabel titleLabel = new JLabel("Title: " + title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setSize(260, 25);
        add(titleLabel);

        JLabel idLabel = new JLabel("Ticket ID: " + ticketId);
        idLabel.setForeground(Color.WHITE);
        idLabel.setSize(260, 25);
        idLabel.setLocation(20, 50);
        add(idLabel);

        JComboBox<String> assigneeDropdown = new JComboBox<>(assignees); //array of staff
        assigneeDropdown.setSize(260, 30);
        assigneeDropdown.setLocation(20, 90);
        add(assigneeDropdown);

        JButton confirmButton = new JButton("idk button for smthn");
        confirmButton.setSize(260, 30);
        confirmButton.setLocation(20, 140);
        add(confirmButton);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sample Ticket");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(0x2F2D49));
        int i;
        int count = 0;
        GridBagConstraints gbc = new GridBagConstraints();
        for (i = 0; i < 3; i++) {
            SampleTicket ticket = new SampleTicket("Ticket " + i, 1000 + i, new String[]{"User A", "User B"});
        
            // Move to next row every 3 items
            gbc.gridx = i % 3;          // column: 0, 1, 2
            gbc.gridy = i / 3;          // row: increases every 3 items
        
            mainPanel.add(ticket, gbc);
        }

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}


