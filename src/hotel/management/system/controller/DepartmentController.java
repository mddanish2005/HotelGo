/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.controller;

import hotel.management.system.dao.DepartmentDAO;
import hotel.management.system.model.Department;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danish
 */
public class DepartmentController {
    
    DepartmentDAO departmentDao = new DepartmentDAO();
    
    public String[] getAllDepartmentNames()
    {
       List<Department> departments = new ArrayList();
        try {
            departments = departmentDao.getAllDepartments();
        } catch (SQLException ex) {
            System.getLogger(DepartmentController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       String[] departmentNames = new String[departments.size()];
      
       int i = 0;
       for(Department department : departments)
       {
           departmentNames[i] = department.getDepartmentName();
           i++;
       }
       
       return departmentNames;
    }
    
}
