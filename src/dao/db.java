package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class db {
    Dotenv dotenv = Dotenv.load();

    String url = dotenv.get("DB_URL");
    String user = dotenv.get("DB_USER");
    String password = dotenv.get("DB_PASS");

    final String dbURL = url;
    Connection con = null;
    PreparedStatement pstat = null;
    int i = 0;

    public void newTicket(String description, String status, String priority){
        try{
            con = DriverManager.getConnection(url, user, password);
            pstat = con.prepareStatement("INSERT INTO Ticket (description, status, priority) VALUES (?,?,?)");
            pstat.setString(1, description);
            pstat.setString(2, status);
            pstat.setString(3, priority);
            i = pstat.executeUpdate();
            System.out.println(i + " record successfully added to the table .");
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally{
            try{
                pstat.close();
                con.close();
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public boolean isValidLogin(String username, String password){
        
    }
}
