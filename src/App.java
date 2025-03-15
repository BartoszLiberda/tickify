import gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Login loginWindow = new Login(); 
            loginWindow.setVisible(true); 
        });
    }
}
