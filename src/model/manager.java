package model;
public class manager {
    //vars
    private static int manID = 1;
    private int managerID;
    private String loginName;
    private String password;
    private ticketv2[] assignableTickets = new ticketv2[20];
    private int numTickets;
    private supportAgent[] SupportAgents = new supportAgent[5];
    private int numEmployees;
    
    
    //constructors
    public manager() {
        this.managerID = 0;
        this.loginName = "";
        this.password = "";
        this.numEmployees = 0;
        this.numTickets = 0;
    }
    
    public manager(String loginName, String password) {
        this.managerID = manID;
        this.loginName = loginName;
        this.password = password;
        this.numTickets = 0;
        this.numEmployees = 0;
        manID++;
    }

    //getters
    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public int getManID() {
        return manID;
    }

    public ticketv2[] getAssignableTickets() {
        int i = 0;
        while (i < assignableTickets.length && assignableTickets[i] != null) {
            System.out.println("Ticket ID: " + assignableTickets[i].getTicketId());
            i++;
        }
        return assignableTickets;
    }
    
    //methods
    public void addEmployee(supportAgent employee){
        if(numEmployees < 5){
            SupportAgents[numEmployees] = employee;
            numEmployees++;
        } 
        else {
            System.out.println("You have reached the maximum number of employees.");
        }
    }


    public void addTicket(ticketv2 newTicket){
        if(numTickets < 20){
            assignableTickets[numTickets] = newTicket;
            numTickets++;
            if(numTickets > 15)
            {
            System.out.println("Please Manage tickets before count exceeds 20!\nIf you have 20the system cannot take in more...");
            }
        } 
        else {
            System.out.println("You have reached the maximum number of tickets.");
        }
    }

    public void deleteTicket(int ticketId){
        for(int i = 0; i < numTickets; i++)
        {
            if(ticketId == assignableTickets[i].getTicketId()){
                for(int j = i; j < assignableTickets.length-1; j++){
                    assignableTickets[j] = assignableTickets[j+1];                   
                }
                numTickets--;
                assignableTickets[numTickets] = null;
                System.out.println("Ticket with ID: " + ticketId + " has been deleted.");
                return;
            }
        }
        System.out.println("Ticket with ID: " + ticketId + " not found.");
    }

    public void assignTicket(int location, int employeeID){
        for(int i = 0; i < numTickets; i++){
            if(location == assignableTickets[i].getTicketId()){
                for(int j = 0; j < numEmployees; j++){
                    if(employeeID == SupportAgents[j].getEmployeeID())
                    {
                        SupportAgents[j].addClientTicket(assignableTickets[i]);
                        for(int x = i; x < assignableTickets.length-1; x++){
                            assignableTickets[x] = assignableTickets[x+1];                   
                        }
                        numTickets--;
                        assignableTickets[numTickets] = null;
                    }
                }
            }
        }
        System.out.println("Ticket with ID: " + location + " not found.");
    }
}
