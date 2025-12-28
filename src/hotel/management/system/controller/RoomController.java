
package hotel.management.system.controller;

import hotel.management.system.dao.RoomDAO;
import hotel.management.system.model.Room;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danish
 */
public class RoomController {
    
    RoomDAO roomdao = new RoomDAO();
    
    public boolean addRoom(Room rm)
    {
        
        try {
          return  roomdao.addRoom(rm);
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    public List<Room> getAvailableRooms()
    {
        try {
            return roomdao.getAvailableRooms();
           
              
            
            
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    
    public Room getRoomByRoomNo(String roomNo)
    {
        try {
            return roomdao.getRoomByRoomNo(roomNo);
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    return null;
    
    }
    
    public List<Room> getAllRoom()
    {
        try {
          return  roomdao.getAllRoom();
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    
}
