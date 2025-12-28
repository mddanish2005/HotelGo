/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.util.Conn;
import java.sql.*;
import hotel.management.system.model.Driver;

public class DriverDAO {

    public boolean addDriver(Driver dv) throws SQLException {

        String sql = """
        INSERT INTO driver
        (name, age, car_model, car_company, location, gender, availability)
        VALUES (?, ?, ?, ?, ?, ?, ?)
    """;

        try (Connection con = Conn.getMySqlConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dv.getName());
            ps.setInt(2, dv.getAge());
            ps.setString(3, dv.getCarModel());
            ps.setString(4, dv.getCarCompany());
            ps.setString(5, dv.getLocation());
            ps.setString(6, dv.getGender());
            ps.setString(7, dv.getAvailability());
            boolean res = ps.executeUpdate() > 0;
            con.close();
            return res;
        }

    }

}
