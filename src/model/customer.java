package model;
public class customer{
    //vars
    private static int custIDs = 1;
    private int customerID;
    private String loginName;
    private String password;
    private ticketv2[] Tickets = new ticketv2[5];
    private int numTickets;


    //constructors
    customer(){
        this.customerID = 0;
        this.loginName = "";
        this.password = "";
        this.numTickets = 0;
    }

    customer(String loginName, String password){
        this.customerID = custIDs;
        this.loginName = loginName;
        this.password = password;
        this.numTickets = 0;
        custIDs++;
    }

    //getters
    public int getCustID() {
        return customerID;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public int getNumTickets(){
        return numTickets;
    }

    //setters
    public void setCustID(int custID) {
        this.customerID = custID;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    //methods
    public void createTicket(String title, String desc, int customerID){
        if(numTickets < 5){
            ticketv2 newTicket = new ticketv2(title, desc, customerID);
            Tickets[numTickets] = newTicket;
            numTickets++;
        } else {
            System.out.println("You have reached your maximum number of tickets.");
        }
    }

}