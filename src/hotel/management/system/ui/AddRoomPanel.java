/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui;

import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Room;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 *
 * @author danish
 */
public class AddRoomPanel extends JFrame implements ActionListener {

    JTextField roomNof, pricef;
    JComboBox cbAvail, cbCleanStatus, cbBedType;
    JButton submit, back;

    AddRoomPanel() {

        setLayout(null);
        setBounds(500, 250, 900, 650);
        getContentPane().setBackground(Color.white);

        //Labels
        JLabel roomNo = new JLabel("Room Number");
        JLabel avail = new JLabel("Availaible");
        JLabel cleanStatus = new JLabel("Cleaning Status");
        JLabel price = new JLabel("Price");
        JLabel bedType = new JLabel("Bed Type");
        int y = 50;

        JLabel[] labels = {roomNo, avail, cleanStatus, price, bedType};
        for (JLabel l : labels) {
            l.setBounds(60, y, 200, 30);
            l.setFont(new Font("serif", Font.PLAIN, 17));
            add(l);
            y = y + 70;
        }

        //TextFields
        roomNof = new JTextField();
        roomNof.setBounds(300, 50, 150, 30);
        add(roomNof);
        pricef = new JTextField();
        pricef.setBounds(300, 260, 150, 30);
        add(pricef);

        //ComboBox
        String[] str1 = {"Available", "Occupied"};
        cbAvail = new JComboBox(str1);
        cbAvail.setBounds(300, 120, 150, 30);
        cbAvail.setBackground(Color.white);
        cbAvail.setFont(new Font("serif", Font.PLAIN, 15));
        add(cbAvail);
        String[] str2 = {"Cleaned", "Dirty"};
        cbCleanStatus = new JComboBox(str2);
        cbCleanStatus.setBounds(300, 190, 150, 30);
        cbCleanStatus.setBackground(Color.white);
        cbCleanStatus.setFont(new Font("serif", Font.PLAIN, 15));
        add(cbCleanStatus);

        String[] str3 = {"Single Bed", "Double Bed"};
        cbBedType = new JComboBox(str3);
        cbBedType.setBounds(300, 330, 150, 30);
        cbBedType.setBackground(Color.white);
        cbBedType.setFont(new Font("serif", Font.PLAIN, 15));
        add(cbBedType);

        //Buttons
        submit = new JButton("Submit");
        submit.setBounds(390, 450, 120, 50);
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

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 340, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(490, 60, 400, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRoomPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            RoomController roomController = new RoomController();

            Room room = new Room(
                    roomNof.getText(),
                    (String) cbAvail.getSelectedItem(),
                    (String) cbCleanStatus.getSelectedItem(),
                    BigDecimal.valueOf(Double.parseDouble(pricef.getText())),
                    (String) cbBedType.getSelectedItem()
            );
            if (roomController.addRoom(room)) {
                 dispose();
                JOptionPane.showMessageDialog(
                        null, "Room Added Successfully"
                );
               
            } else {
                JOptionPane.showMessageDialog(
                        null, "Invalid Details - Try again"
                );

            }
        }

        if (e.getSource() == back) {
            dispose();
        }
    }
}
