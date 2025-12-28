/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.util.Conn;
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
                     (id_type,id_number,name,gender,country,room_no,deposit)
                     values(?,?,?,?,?,?,?)
                     
                     """;

        String sql2 = """
                      UPDATE room
                      SET availability = 'Occupied'
                      WHERE room_no = ? ;
                      """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setString(1, customer.getRoomNo());

        ps.setString(1, customer.getIdType());
        ps.setString(2, customer.getIdNumber());
        ps.setString(3, customer.getName());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getRoomNo());
        ps.setBigDecimal(7, customer.getDeposit());

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
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getTimestamp(8).toLocalDateTime(),
                    rs.getBigDecimal(9)
            )
            );

        }
        return customers;
    }

}
