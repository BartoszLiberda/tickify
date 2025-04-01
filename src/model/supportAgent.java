package model;
public class supportAgent {
    //vars
    private static int empID;
    private int employeeID;
    private String loginName;
    private String password;
    private ticketv2[] clienttickets = new ticketv2[20];
    private int numTickets;


    //constructors
    supportAgent(){
        this.employeeID = 0;
        this.loginName = "";
        this.password = "";
        this.numTickets = 0;
    }

    supportAgent(String loginName, String password){
        this.employeeID = empID;
        this.loginName = loginName;
        this.password = password;
        this.numTickets = 0;
        empID++;
    }

    //getters
    public int getEmployeeID(){
        return employeeID;
    }

    public String getLoginName(){
        return loginName;
    }

    public String getPassword(){
        return password;
    }

    public ticketv2[] getClientTickets(){
        return clienttickets;
    }
    //setters
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    public void setPassword(String password){
        this.password = password;
    }
    //methods
    public void addClientTicket(ticketv2 newTicket){
        if(numTickets < 20){
            clienttickets[numTickets] = newTicket;
            numTickets++;
        } else {
            System.out.println("You have reached the maximum number of tickets.");
        }
    }

}
