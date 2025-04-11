package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gui.MainMenu;
import io.github.cdimascio.dotenv.Dotenv;
import model.User;
import model.Ticket;

public class db {
    Dotenv dotenv = Dotenv.load();

    String url = dotenv.get("DB_URL");
    String user = dotenv.get("DB_USER");
    String password = dotenv.get("DB_PASS");

    final String dbURL = url;
    Connection con = null;
    PreparedStatement pstat = null;
    int i = 0;

    private MainMenu mainMenu;

    public db(){

    }

    public db(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

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

    public void newUser(String name, String surname, String email, String username, String userpassword){
        try{
            con = DriverManager.getConnection(url, user, password);
            pstat = con.prepareStatement("INSERT INTO Users (username, password, name, surname, email) VALUES (?,?,?,?,?)");
            pstat.setString(1, username);
            pstat.setString(2, userpassword);
            pstat.setString(3, name);
            pstat.setString(4, surname);
            pstat.setString(5, email);
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

    public boolean isValidLogin(String username, String userpassword){
        try{
            con = DriverManager.getConnection(url, user, password);
            pstat = con.prepareStatement("SELECT id, username, password, name, surname, email, type FROM Users");
            ResultSet i = pstat.executeQuery();

            while(i.next()){
                int userIdDB = i.getInt("id");
                String usernameDB = i.getString("username");
                String passwordDB = i.getString("password");
                String nameDB = i.getString("name");
                String surnameDB = i.getString("surname");
                String emailDB = i.getString("email");
                String typeDB = i.getString("type");

                if(username.equals(usernameDB) && userpassword.equals(passwordDB)){
                    User currentUser = new User(userIdDB,nameDB,surnameDB,emailDB,usernameDB,passwordDB,typeDB);
                    mainMenu.saveUser(currentUser);
                    return true;
                }
            }
            return false;
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
        return false;
    }

    public List<Ticket> getUserTickets(int userID){
        List<Ticket> tickets = new ArrayList<>() ;
        try{
            con = DriverManager.getConnection(url, user, password);
            pstat = con.prepareStatement("SELECT * FROM Ticket WHERE status != 'Closed' AND CustomerID = (?)");
            pstat.setInt(1, userID);
            ResultSet i = pstat.executeQuery();

            while(i.next()){
                int ticektIdDB = i.getInt("id");
                String ticketDescDB = i.getString("description");
                String ticketStatusDB = i.getString("status");
                int customerIdDB = i.getInt("customerID");
                String ticektPriorityDB = i.getString("priority");
                int agentIdDB = i.getInt("agentID");

                Ticket ticket = new Ticket(ticektIdDB,ticketDescDB,ticketStatusDB,customerIdDB,ticektPriorityDB,agentIdDB);
                tickets.add(ticket);
            }
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
        return tickets;
    }
}
