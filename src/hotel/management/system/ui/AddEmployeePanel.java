/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui;

import hotel.management.system.controller.EmployeeController;
import hotel.management.system.model.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 *
 * @author danish
 */
public class AddEmployeePanel extends JFrame implements ActionListener {

    JButton submit,back;

    JLabel name, age, gender, job, salary, phone;

    JTextField namef, agef, salaryf, phonef;

    JRadioButton male, female;
    ButtonGroup genderGroup;

    JComboBox jobs;

    public AddEmployeePanel() {
        setLayout(null);
        setBounds(500, 250, 900, 650);
        getContentPane().setBackground(Color.white);
      
        //Buttons
        submit = new JButton("Submit");
        submit.setBounds(390, 500, 120, 50);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD, 18));
        add(submit);
        submit.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(550, 500, 120, 50);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("serif", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);
        

        //Labels
        name = new JLabel("Name");
        age = new JLabel("Age");
        gender = new JLabel("Gender");
        job = new JLabel("Job");
        salary = new JLabel("Salary");
        phone = new JLabel("Phone");
        int y = 50;

        JLabel[] labels = {name, age, salary, phone, gender, job};
        for (JLabel l : labels) {
            l.setBounds(60, y, 100, 30);
            l.setFont(new Font("serif", Font.PLAIN, 17));
            add(l);
            y = y + 70;
        }

        //TextFields
        namef = new JTextField();
        agef = new JTextField();
        salaryf = new JTextField();
        phonef = new JTextField();
        JTextField[] fields = {namef, agef, salaryf, phonef};
        int y2 = 50;
        for (JTextField f : fields) {
            f.setBounds(250, y2, 150, 30);
            y2 = y2 + 70;
            add(f);
        }

        //Radio
        genderGroup = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(250, 330, 60, 30);

        female = new JRadioButton("Female");
        female.setBounds(330, 330, 80, 30);
        genderGroup.add(male);
        genderGroup.add(female);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        add(male);
        add(female);

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 70, 400, 340);
        add(image);

        //ComboBox
        String[] strs = {"Front Desk Clerk", "Kitchen Staff", "Room Service", "Housekeeping"};
        jobs = new JComboBox(strs);
        jobs.setBounds(250, 400, 150, 30);
        jobs.setBackground(Color.white);
        jobs.setFont(new Font("serif", Font.PLAIN, 15));
        add(jobs);
        setVisible(true);

    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submit){

        EmployeeController employeeController = new EmployeeController();

        Employee emp;
        emp = new Employee(
                namef.getText(),
                Integer.valueOf(agef.getText()),
                BigDecimal.valueOf(Double.parseDouble(salaryf.getText())),
                phonef.getText(),
                male.isSelected() ? "Male" : "Female",
                (String) jobs.getSelectedItem()
        );

        if (employeeController.addEmployee(emp)) {
            dispose();
            JOptionPane.showMessageDialog(
                    null, "Employee Added Successfully"
            );
            
        } else {
            JOptionPane.showMessageDialog(
                    null, "Invalid Details - try again"
            );
        } 
        }
        
        if(e.getSource() == back)
        {
            dispose();
        }
    }

}
