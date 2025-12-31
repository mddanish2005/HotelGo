/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.controller;

import hotel.management.system.dao.CustomerDAO;
import hotel.management.system.dao.RoomDAO;
import hotel.management.system.model.Customer;
import hotel.management.system.model.Room;
import java.sql.SQLException;
import java.util.List;

public class CustomerController {

    CustomerDAO customerDao = new CustomerDAO();
    RoomController roomController = new RoomController();

    public boolean addCustomer(Customer customer) {
        try {

            if (customer != null) {
                return  customerDao.addCustomer(customer);
            }
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;

    }

    public List<Customer> getCustomerByName(String name) {

        try {
            return customerDao.getCustomerByName(name);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public boolean updateCustomer(Customer customer) {
        try {

            Customer existing = customerDao.getCustomerByCustomerId(customer.getCustomerId());
            if (existing.getRoomNo().equals(customer.getRoomNo())) {
                roomController.occupyRoom(customer.getRoomNo());
                return customerDao.updateCustomer(customer);
            } else {
                roomController.releaseRoom(existing.getRoomNo());
                customerDao.updateCustomer(customer);
            }

            return customerDao.updateCustomer(customer);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public Customer getCustomerByGovernmentId(String id) {
        try {
            return customerDao.getCustomerByGovernmentId(id);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    public Customer getCustomerByCustomerId(int id)
    {
        try {
            return customerDao.getCustomerByCustomerId(id);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public boolean checkOutCustomer(Customer customer){
        
        try {
          return  customerDao.checkOutCustomer(customer);
        } catch (SQLException ex) {
            System.getLogger(CustomerController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
        
    }
}
