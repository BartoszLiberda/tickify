package model;
public class ticketv2 {
        //vars
        private static int ticketcount = 1;
        private int ticketID;
        private String title;
        private String description;
        private String status;
        private String priority;

        private customer customer;
        private manager manager;
        private supportAgent supportAgent;
    
    
        //constructors
        public ticketv2(){
            ticketID = 0;
            title = "";
            description = "";
            status = "Open";
            priority = "Medium";
            customer = null;
            manager = null;
            supportAgent = null;
        }
        //this is the constructor for a customer making a ticket
        public ticketv2(String title, String description, int customerid){
            ticketID = ticketcount;
            ticketcount++;
            this.title = title;
            this.description = description;
            this.status = "Open";
            this.priority = "New";
            // this.customer = customerid; // need to find a way to get the customer via its id
            this.manager = null; //same here as it needs an auto assigned manager, so idk check if a manager has space? then assign to them?
            this.supportAgent = null; //this is fine as the manager will sort this out
        }

        public ticketv2(String title, String description, String status, String priority, customer customer){
            ticketID = ticketcount;
            ticketcount++;
            this.title = title;
            this.description = description;
            this.status = status;
            this.priority = priority;
            this.customer = customer;
            this.manager = null;
            this.supportAgent = null;
        }   
        //getters
        public int getTicketId() {
            return ticketID;
        }
        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description;
        }
        public String getStatus() {
            return status;
        }
        public String getPriority() {
            return priority;
        }
        public customer getCustomer() {
            return customer;
        }
        public manager getManager() {
            return manager;
        }
        public supportAgent getSupportAgent() {
            return supportAgent;
        }
        //setters
        public void setTicketId(int ticketID) {
            this.ticketID = ticketID;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public void setPriority(String priority) {
            this.priority = priority;
        }
        public void setCustomer(customer customer) {
            this.customer = customer;
        }
        public void setManager(manager manager) {
            this.manager = manager;
        }
        public void setSupportAgent(supportAgent supportAgent) {
            this.supportAgent = supportAgent;
        }   
        //methods

}
