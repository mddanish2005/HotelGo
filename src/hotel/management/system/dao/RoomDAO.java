package hotel.management.system.dao;

import hotel.management.system.util.Conn;
import hotel.management.system.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public boolean addRoom(Room room) throws SQLException {
        String sql = """
                    INSERT INTO room
                    (room_no,availability,cleanstatus,price,bedtype)
                    VALUES (?, ?, ?, ?, ?)
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, room.getRoomNo());
        ps.setString(2, room.getAvailability());
        ps.setString(3, room.getCleanStatus());
        ps.setBigDecimal(4, room.getPrice());
        ps.setString(5, room.getBedType());


        return ps.executeUpdate() > 0;

    }

    public List<Room> getAvailableRooms() throws SQLException {
        String sql = """
                Select * from room where
                availability = 'Available'
                AND cleanstatus = 'Cleaned'
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Room> rooms = new ArrayList();
        while (rs.next()) {
            Room rm = new Room(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getBigDecimal(4),
                    rs.getString(5)
            );
            rooms.add(rm);

        }

        return rooms;

    }

    public Room getRoomByRoomNo(String roomNo) throws SQLException {

        String sql = """
                Select * from room where
                room_no = ?
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, roomNo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Room rm = new Room(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getBigDecimal(4),
                    rs.getString(5)
            );
            return rm;

        }

        return null;
    }

    public List<Room> getAllRooms() throws SQLException {
        String sql = """                   
                select * from room
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Room> rooms = new ArrayList();
        while (rs.next()) {
            Room rm = new Room(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getBigDecimal(4),
                    rs.getString(5)
            );
            rooms.add(rm);

        }

        return rooms;

    }

    public boolean deleteRoom(Room rm) throws SQLException {
        String sql = """
                    delete from room
                                  where room_no = ?
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, rm.getRoomNo());

        return ps.executeUpdate() > 0;
    }

    public boolean updateRoom(Room rm) throws SQLException {
       String sql = """
    UPDATE room
    SET
        availability = ?,
        cleanstatus = ?,
        price = ?,
        bedtype = ?
    WHERE room_no = ?
""";


        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, rm.getAvailability());
        ps.setString(2, rm.getCleanStatus());
        ps.setBigDecimal(3, rm.getPrice());
        ps.setString(4, rm.getBedType());
        ps.setString(5, rm.getRoomNo());
        

        return ps.executeUpdate() > 0;

    }

}
