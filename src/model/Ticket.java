package model;
import dao.db;

public class Ticket{
    db db = new db();

    //private static int ticketId = 0;
    private String desc = "";
    private String status = "unsolved";
    private String priority = "normal";

    public Ticket(String d, String s, String p){
        setDesc(d);
        setStatus(s);
        setPriority(p);
        db.newTicket(desc, status, priority);
    }

    public void setID(int ticketId){
        //Get Most Recent ID from DB + 1
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }
}