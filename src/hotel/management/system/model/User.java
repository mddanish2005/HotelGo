package hotel.management.system.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author danish
 */
public class User {

    int userId;
    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public User(int userId , String userName, String password) {
        
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
  

    //getter setter for username
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //getter setter for id
    public int getId() {
        return this.userId;

    }

    public String getPassword() {
        return this.password;

    }

    public void setPassword(String password) {
        this.password = password;
    }

}
