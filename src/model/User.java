package model;

public class User {
    
    private int id;
    private String fName;
    private String sName;
    private String email;
    private String username;
    private String password;
    private String type;

    public User(int id ,String name, String surname, String email, String username, String password, String type){
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setType(type);
    }

    //Setters

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        fName = name;
    }

    public void setSurname(String surname){
        sName = surname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setType(String type){
        this.type = type;
    }

    //Getters

    public int getId(){
        return id;
    }

    public String getName(){
        return fName;
    }

    public String getSurname(){
        return sName;
    }

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getType(){
        return type;
    }

}
