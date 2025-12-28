/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.model.Customer;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danish
 */
public class CustomerDAO {

    public boolean addCustomer(Customer customer) throws SQLException {
        String sql = """
                     insert into customer 
                     (id,id_number,name,gender,country,roomno,check_in_time,deposit)
                     values(?,?,?,?,?,?,?,?)
                     
                     """;

        String sql2 = """
                      UPDATE room
                      SET availability = 'Occupied'
                      WHERE roomno = ? ;
                      """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setString(1, customer.getRoomNo());

        ps.setString(1, customer.getId());
        ps.setString(2, customer.getIdNumber());
        ps.setString(3, customer.getName());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getRoomNo());
        ps.setTimestamp(7, Timestamp.valueOf(customer.getCheckInTime()));
        ps.setBigDecimal(8, customer.getDeposit());

        return (ps2.executeUpdate() > 0) && (ps.executeUpdate() > 0);

    }

    public List<Customer> getCustomerByName(String name) throws SQLException {
        String sql = """
                     select * from customer
                     where name = ?
                     """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        List<Customer> customers = new ArrayList();

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
           
            customers.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getTimestamp(7).toLocalDateTime(),
                    rs.getBigDecimal(8))
            );

        }
        return customers;
    }

}
