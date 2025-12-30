/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.util.Conn;

import java.sql.*;

import hotel.management.system.model.Driver;

public class DriverDAO {

    public boolean addDriver(Driver driver) throws SQLException {

        String sql = """
                    INSERT INTO driver
                    (name, age, car_model, car_company, location, gender, availability)
                    VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, driver.getName());
        ps.setInt(2, driver.getAge());
        ps.setString(3, driver.getCarModel());
        ps.setString(4, driver.getCarCompany());
        ps.setString(5, driver.getLocation());
        ps.setString(6, driver.getGender());
        ps.setString(7, driver.getAvailability());
        return ps.executeUpdate() > 0;

    }


    public Driver getDriverById(int driverId) throws SQLException {
        String sql = """ 
                select * from driver 
                where driver_id = ?
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, driverId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Driver(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            );
        }
        return null;
    }

}
