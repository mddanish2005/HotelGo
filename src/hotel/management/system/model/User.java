package hotel.management.system.model;

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
