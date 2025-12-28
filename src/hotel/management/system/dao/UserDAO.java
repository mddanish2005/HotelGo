/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.model.User;
import java.sql.*;


public class UserDAO {

    public User getUser(String username) throws SQLException {
        String sql_query = """
                           
                           Select * from user 
                           where username = ?    
                           
                           """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql_query);
        
        ps.setString(1, username);
      
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return new User(
                    rs.getString("username"),
                    rs.getString("password")                         
            );

        } 
        
        
        return null;

    }

}
