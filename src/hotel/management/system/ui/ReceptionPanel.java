/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.*;

public class ReceptionPanel extends JFrame implements ActionListener {

    String[] str = {"New Customer Form ", "Room", "Department", "All Employee Info",
        "Customer Info ", "Manager Info", "Check Out", "Update Status", "Update Room Status",
        "PickUp Service", "Search Room", "Logout"};

    JButton[] buttons = new JButton[str.length];

    ReceptionPanel() {
        setLayout(null);
        setBounds(500, 150, 1000, 800);
        getContentPane().setBackground(Color.white);

        int y = 50;

        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton(str[i]);
            buttons[i].setBackground(Color.black);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("serif", Font.BOLD, 18));
            buttons[i].setBounds(30, y, 300, 40);
            buttons[i].addActionListener(this);
            add(buttons[i]);
            y = y + 60;

        }

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 30, 600, 700);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ReceptionPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            new NewCustomerPanel();
            dispose();
        }
        if (e.getSource() == buttons[1]) {
            new RoomPanel();
            dispose();
        }
//} else if (e.getSource() == buttons[2]) {
//    new DepartmentPanel();
//
//} else if (e.getSource() == buttons[3]) {
//    new AllEmployeeInfoPanel();
//
//} else 
        if (e.getSource() == buttons[4]) {
            new CustomerInfoPanel();
            dispose();
        }
//} else if (e.getSource() == buttons[5]) {
//    new ManagerInfoPanel();
//
//} else if (e.getSource() == buttons[6]) {
//    new CheckOutPanel();
//
//} else if (e.getSource() == buttons[7]) {
//    new UpdateStatusPanel();
//
//} else if (e.getSource() == buttons[8]) {
//    new UpdateRoomStatusPanel();
//
//} else if (e.getSource() == buttons[9]) {
//    new PickUpServicePanel();
//
//} else if (e.getSource() == buttons[10]) {
//    new SearchRoomPanel();
//
//} else 
        if (e.getSource() == buttons[11]) {
            new LogoutPanel();
            dispose();
        }

    }
}
