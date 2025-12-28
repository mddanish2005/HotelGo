/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.controller;

import hotel.management.system.dao.EmployeeDAO;
import hotel.management.system.model.Employee;
import java.sql.SQLException;
import java.util.List;


public class EmployeeController {
    
    EmployeeDAO empDao = new EmployeeDAO();
    
    public boolean addEmployee(Employee emp)
    {
        try {
            return empDao.addEmployee(emp);
            
       
        } catch (SQLException ex) {
            System.getLogger(EmployeeController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
        
    }
    
    public List<Employee> getAllEmployee()
    {
        try {
            return empDao.getAllEmployee();
        } catch (SQLException ex) {
            System.getLogger(EmployeeController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
