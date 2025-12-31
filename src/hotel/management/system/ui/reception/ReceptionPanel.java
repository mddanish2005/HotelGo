package hotel.management.system.ui.reception;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

public class ReceptionPanel extends JFrame implements ActionListener {
    
String[] str = {
    "New Check-In",
    "Customer List",
    "Edit Stay Details",
    "Guest Check-Out",
    "Room Availability",
    "Room Management",
    "Employee Records",
    "Department Records",
    "Pick-Up Service",
    "Logout"
};


    JButton[] buttons = new JButton[str.length];
    JButton backButton;

    public ReceptionPanel() {

        setLayout(null);
        setBounds(420, 30, 1250, 950);
        getContentPane().setBackground(new Color(242, 242, 242));
        setTitle("Reception");

        JLabel heading = new JLabel("Reception Desk");
        heading.setBounds(40, 20, 400, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(60, 60, 60));
        add(heading);

        int y = 90;

        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton(str[i]);
            buttons[i].setBounds(40, y, 360, 48);
            buttons[i].setBackground(new Color(33, 150, 243));
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 17));
            buttons[i].setFocusPainted(false);
            buttons[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttons[i].addActionListener(this);
            add(buttons[i]);

            y += 62;
        }

        backButton = new JButton("Back");
        backButton.setBounds(40, y + 20, 360, 48);
        backButton.setBackground(new Color(90, 90, 90));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        backButton.setFocusPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/reception.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(760, 860, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(440, 40, 760, 860);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ReceptionPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            new NewCheckinPanel();
        }

        if (e.getSource() == buttons[1]) {
            new AllCustomersInfoPanel();
        }

        if (e.getSource() == buttons[2]) {
            new UpdateCustomerStatusPanel();
        }
        
        if(e.getSource() == buttons[3]){
            new CheckOutPanel();
        }

        if (e.getSource() == buttons[4]) {
            new AllRoomsInfoPanel();
        }

        if(e.getSource() == buttons[5]){
            new RoomManagementPanel();
        }
        if (e.getSource() == buttons[6]) {
            new AllEmployeesInfoPanel();
        }

        if (e.getSource() == buttons[7]) {
            new AllDepartmentsInfoPanel();
        }

        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
