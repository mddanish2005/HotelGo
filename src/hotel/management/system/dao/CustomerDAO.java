/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.dao;

import hotel.management.system.util.Conn;
import hotel.management.system.model.Customer;

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
        String sql  = """
                insert into customer 
                (government_id_type,government_id_number,name,gender,country,room_no,deposit,total_bill)
                values(?,?,?,?,?,?,?,?)
                
                     
                """;
        
        String sql2 = """
                     update room set availability = 'Occupied' where room_no =?""";
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps.setString(1, customer.getIdType());
        ps.setString(2, customer.getIdNumber());
        ps.setString(3, customer.getName());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getRoomNo());
        ps.setBigDecimal(7, customer.getDeposit());
        ps.setBigDecimal(8, customer.getTotalBill());
        
        ps2.setString(1, customer.getRoomNo());
        
        con.setAutoCommit(false);
        ps.executeUpdate();
        ps2.executeUpdate();
        
        con.commit();
        
        return true;

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

            customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8).toLocalDateTime(), rs.getBigDecimal(9), rs.getBigDecimal(10)));

        }
        return customers;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        String sql = """
                Select * from customer""";

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Customer> customers = new ArrayList();
        while (rs.next()) {
            customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8).toLocalDateTime(), rs.getBigDecimal(9), rs.getBigDecimal(10)));
        }
        return customers;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {

        String sql = """
                UPDATE customer
                SET government_id_type =? , government_id_number = ?, name=?, gender=?, country=?, room_no=?, deposit=? , total_bill = ?
                WHERE customer_internal_id=?
                """;
        
        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customer.getIdType());
        ps.setString(2,customer.getIdNumber());
              
        ps.setString(3, customer.getName());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getRoomNo());
        ps.setBigDecimal(7, customer.getDeposit());
        ps.setBigDecimal(8, customer.getTotalBill());
        
        ps.setInt(9, customer.getCustomerId());

        return ps.executeUpdate() > 0;

    }

    public Customer getCustomerByGovernmentId(String id) throws SQLException {
        String sql = """
                select * from customer
                where government_id_number = ?
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8).toLocalDateTime(), rs.getBigDecimal(9), rs.getBigDecimal(10)
            );

        }
        return null;
    }
    
    
     public Customer getCustomerByCustomerId(int id) throws SQLException {
        String sql = """
                select * from customer
                where customer_internal_id = ?
                """;

        Connection con = Conn.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8).toLocalDateTime(), rs.getBigDecimal(9), rs.getBigDecimal(10)
            );

        }
        return null;
    }
    
    
    
}
