package model;
import dao.db;

public class Ticket{

    private int ticketId;
    private String desc;
    private String status;
    private int customerID;
    private String priority;
    private int agentID;

    public Ticket(int id, String desc, String status, int customerID, String priority, int agentID){
        setID(id);
        setDesc(desc);
        setStatus(status);
        setCustomer(customerID);
        setPriority(priority);
        setAgent(agentID);
    }

    public void setID(int id){
        id = ticketId;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setCustomer(int customerID){
        this.customerID = customerID;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public void setAgent(int agentID){
        this.agentID = agentID;
    }

    public int getId(){
        return ticketId;
    }

    public String getDesc(){
        return desc;
    }

    public String getStatus(){
        return status;
    }

    public int getCustomerId(){
        return customerID;
    }

    public String getPriority(){
        return priority;
    }

    public int getAgentId(){
        return agentID;
    }
}