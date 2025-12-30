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
        (name, age, salary, phone, gender, job , department_name)
        VALUES (?, ?, ?, ?, ?, ? , ?)
    """;
       
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, emp.getName());
        ps.setInt(2, emp.getAge());
        ps.setBigDecimal(3, emp.getSalary());
        ps.setString(4, emp.getPhone());
        ps.setString(5, emp.getGender());
        ps.setString(6, emp.getJob());
        ps.setString(7, emp.getDepartmentName());

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
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    rs.getString("department_name")
            ));

        }
        return emps;
    }
    
    public Employee getEmployeeById(int empid) throws SQLException
    {
         String sql = """
                     select * from employee where emp_id = ?""";
         
         
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, empid);
        ResultSet rs = ps.executeQuery();
       
        if(rs.next())
        {
            return new Employee(
                    rs.getInt("emp_id"),
                    rs.getString("name"),
                    rs.getObject("age", Integer.class),
                    rs.getBigDecimal("salary"),
                    rs.getString("phone"),
                    rs.getString("gender"),
                    rs.getString("job"),
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    rs.getString("department_name")
            );
        }
        return null;
        
    }

    public List<Employee> getEmployeeByName(String name) throws SQLException {
        String sql = """
                     select * from employee where name = ?""";
        Connection con = Conn.getMySqlConnection(); 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

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
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    rs.getString("department_name")
            ));

        }
        return emps;
    }

    public boolean deleteEmployee(int empId) throws SQLException {
        String sql = """
                     delete from employee 
                     where emp_id = ?""";
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, empId);

        return ps.executeUpdate() > 0;
    }

    public boolean updateEmployee(Employee emp) throws SQLException {
        String sql = """
        UPDATE employee
        SET name=?, age=?, salary=?, phone=?, gender=?, job=?, department_name=?
        WHERE emp_id=?
    """;
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, emp.getName());
        ps.setObject(2, emp.getAge()); // nullable
        ps.setBigDecimal(3, emp.getSalary());
        ps.setString(4, emp.getPhone());
        ps.setString(5, emp.getGender());
        ps.setString(6, emp.getJob());
        ps.setString(7, emp.getDepartmentName());
        ps.setInt(8, emp.getEmpId());

        return ps.executeUpdate() > 0;
    }

}
