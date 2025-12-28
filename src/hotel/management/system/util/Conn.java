package hotel.management.system.util;

import java.sql.*;

public class Conn {

    private Conn() {
    }

    public static Connection getMySqlConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(Conn.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "admin", "admin");

        return con;

    }

}
