package hotel.management.system.ui.reception;

import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class RoomManagementPanel extends JFrame implements ActionListener {

    private JComboBox<String> roomNoComboBox;
    private JComboBox<String> availabilityComboBox;
    private JComboBox<String> cleanStatusComboBox;
    private JComboBox<String> bedTypeComboBox;

    private JTextField priceField;

    private JButton loadBtn;
    private JButton updateBtn;
    private JButton backBtn;
    
    Room room;

    private final RoomController roomController = new RoomController();

    public RoomManagementPanel() {

        setTitle("Room Management");
        setBounds(450, 170, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Room Management");
        heading.setBounds(60, 30, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 32));
        add(heading);

        addLabel("Room Number", 110);
        addLabel("Availability", 170);
        addLabel("Clean Status", 230);
        addLabel("Price", 290);
        addLabel("Bed Type", 350);

        roomNoComboBox = new JComboBox<>(roomController.getAllRoomNos());
        roomNoComboBox.setBounds(300, 110, 220, 32);
        add(roomNoComboBox);

        loadBtn = new JButton("Load");
        loadBtn.setBounds(540, 110, 100, 32);
        styleButton(loadBtn);
        add(loadBtn);
        loadBtn.addActionListener(this);

        availabilityComboBox = new JComboBox<>(new String[]{"Available", "Occupied"});
        availabilityComboBox.setBounds(300, 170, 220, 32);
        add(availabilityComboBox);

        cleanStatusComboBox = new JComboBox<>(new String[]{"Clean", "Dirty"});
        cleanStatusComboBox.setBounds(300, 230, 220, 32);
        add(cleanStatusComboBox);

        priceField = new JTextField();
        priceField.setBounds(300, 290, 220, 32);
        add(priceField);

        bedTypeComboBox = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        bedTypeComboBox.setBounds(300, 350, 220, 32);
        add(bedTypeComboBox);

        updateBtn = new JButton("Update Room");
        updateBtn.setBounds(300, 430, 160, 45);
        styleButton(updateBtn);
        add(updateBtn);
        updateBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(480, 430, 120, 45);
        styleButton(backBtn);
        add(backBtn);
        backBtn.addActionListener(this);


        setVisible(true);
    }

    private void addLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(80, y, 200, 30);
        label.setFont(new Font("Serif", Font.BOLD, 17));
        add(label);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Serif", Font.BOLD, 16));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loadBtn) {

            room = roomController.getRoomByRoomNo(
                    (String) roomNoComboBox.getSelectedItem()
            );

            if (room == null) {
                JOptionPane.showMessageDialog(this, "Room not found");
                return;
            }

            availabilityComboBox.setSelectedItem(room.getAvailability());
            cleanStatusComboBox.setSelectedItem(room.getCleanStatus());
            priceField.setText(room.getPrice().toString());
            bedTypeComboBox.setSelectedItem(room.getBedType());
        }

        if (e.getSource() == updateBtn) {
            
              Room roomUpdated = new Room(
                     (String) roomNoComboBox.getSelectedItem(),
                    (String) availabilityComboBox.getSelectedItem(),
                    (String) cleanStatusComboBox.getSelectedItem(),
                    BigDecimal.valueOf(Double.parseDouble(priceField.getText())),
                    (String) bedTypeComboBox.getSelectedItem()
            );
            
            if(roomController.updateRoom(roomUpdated)){
                 JOptionPane.showMessageDialog(this, "Room updated successfully");
                 dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Error occured");
            }
           
        }

        if (e.getSource() == backBtn) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new RoomManagementPanel();
    }
}
