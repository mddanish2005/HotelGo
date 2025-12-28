
package hotel.management.system.dao;

import hotel.management.system.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoomDAO {
    
    

    public boolean addRoom(Room rm) throws SQLException {
        String sql = """
        INSERT INTO room
        (roomno,availability,cleanstatus,price,bedtype)
        VALUES (?, ?, ?, ?, ?)
    """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, rm.getRoomNo());
        ps.setString(2, rm.getAvail());
        ps.setString(3, rm.getCleanStatus());
        ps.setDouble(4, rm.getPrice());
        ps.setString(5, rm.getBedType());

        return ps.executeUpdate() > 0;

    }
    
    public List<Room> getAvailableRooms() throws SQLException
    {
        String sql = """
                     Select * from room where
                     availability = 'Available'
                     AND cleanstatus = 'Cleaned'
                     """;
        
         Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        List<Room> rooms = new ArrayList();
        while(rs.next())
        {
            Room rm = new Room(
                    
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getString(5)              
            );
            rooms.add(rm);
            
        }
        
        return rooms;
        
    }
    
    public Room getRoomByRoomNo(String roomNo) throws SQLException
    {
        
     String sql = """
                     Select * from room where
                     roomno = ?
                     """;
        
         Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, roomNo);
        
        ResultSet rs = ps.executeQuery();
       
        if(rs.next())
        {
            Room rm = new Room(
                    
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getString(5)              
            );
           return rm;
            
        }
        
        return null;
    }
    
    public List<Room> getAllRoom() throws SQLException
    {
        String sql = """
                     
                     select * from room
                     """;
        
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        List<Room> rooms = new ArrayList();
        while(rs.next())
        {
            Room rm = new Room(
                    
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getString(5)              
            );
            rooms.add(rm);
            
        }
        
        return rooms;
        
    }

}
