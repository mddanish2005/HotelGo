package hotel.management.system.ui.admin;

import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AddRoomPanel extends JFrame implements ActionListener {

    JTextField roomNoField, priceField;
    JComboBox availabilityComboBox, cleanStatusComboBox, bedTypeComboBox;
    JButton submitButton, backButton;

    public AddRoomPanel() {

        setLayout(null);
        setBounds(500, 250, 900, 650);
        getContentPane().setBackground(new Color(242, 242, 242));
        setTitle("Add Room");

        JLabel heading = new JLabel("Add New Room");
        heading.setBounds(60, 20, 400, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(60, 60, 60));
        add(heading);

        JLabel roomNo = new JLabel("Room Number");
        JLabel avail = new JLabel("Availability");
        JLabel cleanStatus = new JLabel("Cleaning Status");
        JLabel price = new JLabel("Price");
        JLabel bedType = new JLabel("Bed Type");

        int y = 90;
        JLabel[] labels = {roomNo, avail, cleanStatus, price, bedType};
        for (JLabel l : labels) {
            l.setBounds(80, y, 200, 30);
            l.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            add(l);
            y += 70;
        }

        roomNoField = new JTextField();
        roomNoField.setBounds(320, 90, 180, 34);
        roomNoField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(roomNoField);

        availabilityComboBox = new JComboBox(new String[]{"Available", "Occupied"});
        availabilityComboBox.setBounds(320, 160, 180, 34);
        availabilityComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        availabilityComboBox.setBackground(Color.WHITE);
        add(availabilityComboBox);

        cleanStatusComboBox = new JComboBox(new String[]{"Cleaned", "Dirty"});
        cleanStatusComboBox.setBounds(320, 230, 180, 34);
        cleanStatusComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cleanStatusComboBox.setBackground(Color.WHITE);
        add(cleanStatusComboBox);

        priceField = new JTextField();
        priceField.setBounds(320, 300, 180, 34);
        priceField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(priceField);

        bedTypeComboBox = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedTypeComboBox.setBounds(320, 370, 180, 34);
        bedTypeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        bedTypeComboBox.setBackground(Color.WHITE);
        add(bedTypeComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(320, 460, 140, 45);
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(submitButton);
        submitButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(480, 460, 140, 45);
        backButton.setBackground(new Color(90, 90, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButton.setFocusPainted(false);
        add(backButton);
        backButton.addActionListener(this);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image img = icon.getImage().getScaledInstance(400, 320, Image.SCALE_FAST);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(520, 90, 350, 320);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRoomPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            RoomController roomController = new RoomController();

            Room room = new Room(
                    roomNoField.getText(),
                    (String) availabilityComboBox.getSelectedItem(),
                    (String) cleanStatusComboBox.getSelectedItem(),
                    BigDecimal.valueOf(Double.parseDouble(priceField.getText())),
                    (String) bedTypeComboBox.getSelectedItem()
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

        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
