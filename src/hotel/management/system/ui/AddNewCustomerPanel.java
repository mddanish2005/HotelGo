/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui;

import hotel.management.system.controller.CustomerController;
import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Customer;
import hotel.management.system.model.Room;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author danish
 */
public class AddNewCustomerPanel extends JFrame implements ActionListener {

    JButton submit, back;

    JLabel id, number, name, gender, country, allocateRoomNo, checkinTime, deposit, showCheckInTime;

    JTextField numberField, nameField, countryField, depositField;

    JComboBox idComboBox;
    JComboBox allocateRoomNoComboBox;

    JRadioButton male, female;
    ButtonGroup genderGroup;

    RoomController roomController = new RoomController();
    CustomerController customerController = new CustomerController();

    List<Room> rooms;

    public AddNewCustomerPanel() {
        setLayout(null);
        setBounds(500, 250, 900, 650);
        getContentPane().setBackground(Color.white);

        //Buttons
        submit = new JButton("Submit");
        submit.setBounds(690, 520, 120, 50);
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
        id = new JLabel("Id");
        gender = new JLabel("Gender");
        number = new JLabel("Number");
        country = new JLabel("Country");
        allocateRoomNo = new JLabel("Allocate Room Number");
        checkinTime = new JLabel("Check-in Time");
        deposit = new JLabel("Deposit");
        int y = 50;

        JLabel[] labels = {id, number, name, gender, country, allocateRoomNo, checkinTime, deposit};
        for (JLabel l : labels) {
            l.setBounds(60, y, 150, 30);
            l.setFont(new Font("serif", Font.PLAIN, 17));
            add(l);
            y = y + 70;
        }

        //Inputinggg.......
        String[] op = {"Passport", "Aadhar"};
        idComboBox = new JComboBox(op);
        idComboBox.setBounds(250, 50, 150, 30);
        idComboBox.setBackground(Color.white);
        idComboBox.setForeground(Color.black);
        idComboBox.setFont(new Font("serif", Font.PLAIN, 15));
        add(idComboBox);

        numberField = new JTextField();
        numberField.setBounds(250, 120, 150, 30);
        add(numberField);

        nameField = new JTextField();
        nameField.setBounds(250, 190, 150, 30);
        add(nameField);

        genderGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        male.setBounds(250, 260, 60, 30);
        female = new JRadioButton("Female");
        female.setBounds(330, 260, 80, 30);
        genderGroup.add(male);
        genderGroup.add(female);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        add(male);
        add(female);

        countryField = new JTextField();
        countryField.setBounds(250, 330, 150, 30);
        add(countryField);

        rooms = roomController.getAvailableRooms();
        String[] roomNos = new String[rooms.size()];
        int i = 0;
        for (Room rm : rooms) {
            roomNos[i] = rm.getRoomNo();
            i++;
        }
        allocateRoomNoComboBox = new JComboBox(roomNos);
        allocateRoomNoComboBox.setBounds(250, 400, 150, 30);
        allocateRoomNoComboBox.setBackground(Color.white);
        allocateRoomNoComboBox.setForeground(Color.black);
        allocateRoomNoComboBox.setFont(new Font("serif", Font.PLAIN, 15));
        add(allocateRoomNoComboBox);
        allocateRoomNoComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String roomNo = (String) e.getItem();

                Room rm = roomController.getRoomByRoomNo(roomNo);
                String prices = "" + rm.getPrice();
                JLabel price = new JLabel(prices);
                price.setBounds(690, 400, 150, 30);
                price.setFont(new Font("serif", Font.PLAIN, 17));
                add(price);

            }
        });

        Date date = new Date();
        showCheckInTime = new JLabel("" + date);
        showCheckInTime.setBounds(250, 470, 150, 30);
        add(showCheckInTime);

        depositField = new JTextField();
        depositField.setBounds(250, 550, 150, 30);
        add(depositField);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 80, 400, 340);
        add(image);

        setVisible(true);

    }

    public static void main(String[] args) {
        new AddNewCustomerPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            if (customerController.addCustomer(new Customer(
                    (String) idComboBox.getSelectedItem(),
                    numberField.getText(),
                    nameField.getText(),
                    male.isSelected() ? "Male" : "Female",
                    countryField.getText(),
                    (String) allocateRoomNoComboBox.getSelectedItem(),
                    new BigDecimal(depositField.getText())
            ))) {
                dispose();
                JOptionPane.showMessageDialog(
                        null, "Customer Added Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null, "Invalid details - try again"
                );

            }

        }

        if (e.getSource() == back) {
            dispose();
        }

    }

}
