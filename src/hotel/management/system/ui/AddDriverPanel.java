/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui;

import hotel.management.system.controller.DriverController;
import hotel.management.system.model.Driver;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author danish
 */
public class AddDriverPanel extends JFrame implements ActionListener {

    JButton submit, back;

    JLabel name, age, gender, avail, carModel, carCompany, location;

    JTextField namef, agef, carModelf, carCompanyf, locationf;

    JRadioButton male, female;
    ButtonGroup genderGroup;

    JComboBox cb;

    public AddDriverPanel() {
        setLayout(null);
        setBounds(500, 250, 900, 650);
        getContentPane().setBackground(Color.white);

        //Buttons
        submit = new JButton("Submit");
        submit.setBounds(470, 470, 120, 50);
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
        avail = new JLabel("Availability");
        carModel = new JLabel("Car Model");
        carCompany = new JLabel("Car Company");
        location = new JLabel("Location");
        int y = 50;

        JLabel[] labels = {name, age, carModel, carCompany, location, gender, avail};
        for (JLabel l : labels) {
            l.setBounds(60, y, 150, 30);
            l.setFont(new Font("serif", Font.PLAIN, 17));
            add(l);
            y = y + 70;
        }

        //TextFields
        namef = new JTextField();
        agef = new JTextField();
        carModelf = new JTextField();
        carCompanyf = new JTextField();
        locationf = new JTextField();
        JTextField[] fields = {namef, agef, carModelf, carCompanyf, locationf};
        int y2 = 50;
        for (JTextField f : fields) {
            f.setBounds(250, y2, 150, 30);
            y2 = y2 + 70;
            add(f);
        }

        //Radio
        genderGroup = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(250, 400, 60, 30);

        female = new JRadioButton("Female");
        female.setBounds(330, 400, 80, 30);
        genderGroup.add(male);
        genderGroup.add(female);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        add(male);
        add(female);

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 80, 400, 340);
        add(image);

        //ComboBox
        String[] strs = {"Available", "Occupied"};
        cb = new JComboBox(strs);
        cb.setBounds(250, 470, 150, 30);
        cb.setBackground(Color.white);
        cb.setFont(new Font("serif", Font.PLAIN, 15));
        add(cb);
        
        
        
        setVisible(true);

    }
    
    public static void main(String[] args)
    {
        new AddDriverPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submit) {
            DriverController driverController = new DriverController();

            Driver dv = new Driver(
                    namef.getText(),
                    Integer.valueOf(agef.getText()),
                    carModelf.getText(),
                    carCompanyf.getText(),
                    location.getText(),
                    male.isSelected() ? "Male" : "Female",
                    (String) cb.getSelectedItem()
            );
            if (driverController.addDriver(dv)) {
                
                dispose();
                JOptionPane.showMessageDialog(
                        null, "Driver Added Successfully"
                );
                
            } else {
                JOptionPane.showMessageDialog(
                        null, "Invalid Details - try again"
                );
                

            }
        }
        
        
        if (e.getSource() == back) {
            dispose();
        }
    }

}
