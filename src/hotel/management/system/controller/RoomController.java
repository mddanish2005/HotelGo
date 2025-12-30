package hotel.management.system.controller;

import hotel.management.system.dao.RoomDAO;
import hotel.management.system.model.Room;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomController {

    RoomDAO roomDao = new RoomDAO();

    public boolean addRoom(Room room) {

        try {
            return roomDao.addRoom(room);
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    public List<Room> getAvailableRooms() {
        try {
            return roomDao.getAvailableRooms();

        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public Room getRoomByRoomNo(String roomNo) {
        try {
            return roomDao.getRoomByRoomNo(roomNo);
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;

    }
    
    public BigDecimal getRoomPrice(String roomNo){     
        Room room = getRoomByRoomNo(roomNo);
        return room.getPrice(); 
    }

    public List<Room> getAllRooms() {
        try {
            return roomDao.getAllRooms();
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public void updateRoom(Room room){
        
        try {
            roomDao.updateRoom(room);
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    
    public boolean occupyRoom(String roomNo)
    {
        
        Room room;
        try {
            room = roomDao.getRoomByRoomNo(roomNo);
            room.setAvailability("Occupied");;
            return roomDao.updateRoom(room);  
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    public String[] getAvailableRoomNos()
    {
        List<Room> rooms = new ArrayList();
        try {
            rooms = roomDao.getAvailableRooms();
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        String[] roomNos = new String[rooms.size()];
        
        int i = 0;
        for(Room room : rooms){
            roomNos[i] = room.getRoomNo();
            i++;
        }
        return roomNos;
    }
    
     public boolean releaseRoom(String roomNo)
    {
        
        Room room;
        try {
            room = roomDao.getRoomByRoomNo(roomNo);
            room.setAvailability("Available");;
            return roomDao.updateRoom(room);  
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
}
