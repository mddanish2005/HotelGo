package hotel.management.system.ui;

import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowRoomsPanel extends JFrame{

    JTable table;
    DefaultTableModel model;

    JButton backBtn;

    RoomController roomController = new RoomController();

    public ShowRoomsPanel() {

        setLayout(null);
        setBounds(500, 150, 1000, 800);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Room Information");
        heading.setBounds(350, 40, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 28));
        add(heading);

        // ===== BACK BUTTON =====
        backBtn = new JButton("Back");
        backBtn.setBounds(50, 40, 120, 35);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("serif", Font.BOLD, 16));
        backBtn.addActionListener(e -> {
            // go back
            dispose();
        });
        add(backBtn);

        // ===== TABLE =====
        String[] columns = {
                "Room No", "Availability", "Clean Status",
                "Price", "Bed Type"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setBounds(50, 120, 900, 500);
        add(table);

        loadRooms();

        setVisible(true);
    }

    private void loadRooms() {
        List<Room> rooms = roomController.getAllRooms();
        model.setRowCount(0);

        for (Room r : rooms) {
            model.addRow(new Object[]{
                    r.getRoomNo(),
                    r.getAvailability(),
                    r.getCleanStatus(),
                    r.getPrice(),
                    r.getBedType()
            });
        }
    }

    public static void main(String[] args) {
        new ShowRoomsPanel();
    }

   
}
