package hotel.management.system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {

    private int empId;
    private String name;
    private Integer age;          // nullable
    private BigDecimal salary;
    private String phone;
    private String gender;        // Male / Female / Other
    private String job;
    private LocalDateTime createdAt;
    private String departmentName;

   //insertion in db
    public Employee(String name, Integer age, BigDecimal salary,
                    String phone, String gender, String job , String departmentName ) {
       
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
        this.gender = gender;
        this.job = job;
        this.departmentName = departmentName;
    }
 
    //retrieval from db
    public Employee(int empId, String name, Integer age, BigDecimal salary,
                String phone, String gender, String job,
                LocalDateTime createdAt,String departmentName) {
    this.empId = empId;
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.phone = phone;
    this.gender = gender;
    this.job = job;
    this.createdAt = createdAt;
    this.departmentName = departmentName;
}

    
    
    // ✅ Getters & Setters
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
   
    public String getDepartmentName()
    {
        return departmentName;
    }
  
}
