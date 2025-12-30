/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.model;

import java.math.BigDecimal;

/**
 *
 * @author danish
 */
public class DepartmentStats {
    
    String departmentName;
    BigDecimal budget;
    Integer employeeCount;
    
    public DepartmentStats(String departmentName , BigDecimal budget , Integer employeeCount)
    {
        this.departmentName = departmentName;
        this.budget = budget;
        this.employeeCount = employeeCount;
    }
    
    //getter and setters
       public String getDepartmentName()
    {
        return departmentName;
    }
       
    public BigDecimal getBudget()
    {
        return this.budget;
    }
    
    public Integer getEmployeeCount()
    {
        return this.employeeCount;
    }
    
}
