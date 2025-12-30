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
public class Department {
    
    private String departmentName;
    private BigDecimal budget;
    
    public Department(String departmentName , BigDecimal budget){
        this.departmentName = departmentName;
        this.budget = budget;
    }
    
    public String getDepartmentName()
    {
        return this.departmentName;
    }
    
    public BigDecimal getDepartmentBudget()
    {
        return this.budget;
    }
    
}
