/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import com.mysql.cj.protocol.Resultset;
import hotel.management.system.model.Department;
import hotel.management.system.model.DepartmentStats;
import hotel.management.system.util.Conn;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DepartmentDAO {

    public List<DepartmentStats> getDepartmentsStats() {
        try {

            String sql = """
                           SELECT 
                           d.department_name,
                           d.budget,
            COUNT(e.emp_id) AS employee_count
            FROM department d LEFT JOIN employee e ON d.department_name = e.department_name
            GROUP BY d.department_name, d.budget                                  
            """;

            Connection con = Conn.getMySqlConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<DepartmentStats> dps = new ArrayList();
            while (rs.next()) {
                dps.add(new DepartmentStats(
                        rs.getString("department_name"),
                        rs.getBigDecimal("budget"),
                        rs.getInt("employee_count")
                ));

            }
            return dps;

        } catch (SQLException ex) {
            System.getLogger(DepartmentDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return null;

    }

    public List<Department> getAllDepartments() throws SQLException {
        String sql = """
                    select * from department""";

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Department> departments = new ArrayList();

        while (rs.next()) {
            departments.add(new Department(
                    rs.getString("department_name"),
                    rs.getBigDecimal("budget")
            ));

        }

        return departments;
    }

    public String[] getAllDepartmentNames() {

        List<String> departments = new ArrayList<>();

        String sql = "SELECT department_name FROM department";

        try (Connection con = Conn.getMySqlConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                departments.add(rs.getString("department_name"));
            }

            return departments.toArray(String[]::new);

        } catch (SQLException ex) {
            System.getLogger(DepartmentDAO.class.getName()).log(System.Logger.Level.ERROR,(String) null, ex);
        }

        return new String[0];
    }

}
