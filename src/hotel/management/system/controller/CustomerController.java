/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.controller;

import hotel.management.system.dao.CustomerDAO;
import hotel.management.system.model.Customer;
import java.sql.SQLException;
import java.util.List;


public class CustomerController {
    
    CustomerDAO customerDao = new CustomerDAO();
    
    public boolean addCustomer(Customer customer)
    {
        try {
            return customerDao.addCustomer(customer);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    return false;
    }
    
    public List<Customer> getCustomerByName(String name)
    {
        
        try {
           return customerDao.getCustomerByName(name);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    return null;
    }
}
