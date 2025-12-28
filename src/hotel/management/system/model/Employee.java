/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.model;

/**
 *
 * @author danish
 */
public class Employee {

    String name;
    int age;
    double salary;
    String phone;
    String gender;
    String job;

    public Employee(String name,
            int age,
            double salary,
            String phone,
            String gender,
            String job
    ) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


