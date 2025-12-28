package hotel.management.system.controller;

import hotel.management.system.dao.RoomDAO;
import hotel.management.system.model.Room;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomController {

    RoomDAO roomDao = new RoomDAO();

    public boolean addRoom(Room rm) {

        try {
            return roomDao.addRoom(rm);
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

    public List<Room> getAllRooms() {
        try {
            return roomDao.getAllRooms();
        } catch (SQLException ex) {
            System.getLogger(RoomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

}
