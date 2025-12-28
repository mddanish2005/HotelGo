
package hotel.management.system.dao;

import hotel.management.system.util.Conn;
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
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password")                         
            );

        } 
        
        
        return null;

    }

}
