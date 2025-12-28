/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.util.Conn;
import hotel.management.system.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, emp.getName());
        ps.setInt(2, emp.getAge());
        ps.setBigDecimal(3, emp.getSalary());
        ps.setString(4, emp.getPhone());
        ps.setString(5, emp.getGender());
        ps.setString(6, emp.getJob());

        return ps.executeUpdate() > 0;

    }

    public List<Employee> getAllEmployee() throws SQLException {
        String sql = """
                 Select *from employee
                 """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Employee> emps = new ArrayList();
        while (rs.next()) {
            emps.add(new Employee(
                    rs.getInt("emp_id"),
                    rs.getString("name"),
                    rs.getObject("age", Integer.class),
                    rs.getBigDecimal("salary"),
                    rs.getString("phone"),
                    rs.getString("gender"),
                    rs.getString("job"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            ));

        }
        return emps;
    }

}
