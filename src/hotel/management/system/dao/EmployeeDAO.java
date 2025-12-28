/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.model.Employee;
import java.sql.*;

/**
 *
 * @author danish
 */
public class EmployeeDAO {

public boolean addEmployee(Employee emp) throws SQLException {

    String sql = """
        INSERT INTO employee
        (name, age, salary, phone, gender, job)
        VALUES (?, ?, ?, ?, ?, ?)
    """;

    try (Connection con = Conn.getMySqlConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, emp.getName());
        ps.setInt(2, emp.getAge());
        ps.setDouble(3, emp.getSalary());
        ps.setString(4, emp.getPhone());
        ps.setString(5, emp.getGender());
        ps.setString(6, emp.getJob());

        return ps.executeUpdate() > 0;
    }
}

}
