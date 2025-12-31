package hotel.management.system.ui.reception;

import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AllRoomsInfoPanel extends JFrame {

    JTable table;
    DefaultTableModel model;

    JButton backBtn;
    JCheckBox availableOnlyCheckBox;

    RoomController roomController = new RoomController();

    public AllRoomsInfoPanel() {

        setLayout(null);
        setBounds(450, 130, 1050, 820);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Room Information");
        heading.setBounds(380, 35, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 40, 120, 35);
        styleButton(backBtn);
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        availableOnlyCheckBox = new JCheckBox("Show Available Rooms Only");
        availableOnlyCheckBox.setBounds(50, 95, 260, 30);
        availableOnlyCheckBox.setBackground(Color.white);
        availableOnlyCheckBox.setFont(new Font("Serif", Font.BOLD, 16));
        add(availableOnlyCheckBox);

        availableOnlyCheckBox.addActionListener(e -> {
            if (availableOnlyCheckBox.isSelected()) {
                loadAvailableRooms();
            } else {
                loadRooms();
            }
        });

        String[] columns = {
                "Room No", "Availability", "Clean Status",
                "Price", "Bed Type"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 150, 930, 520);
        add(scrollPane);

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

    private void loadAvailableRooms() {
        List<Room> rooms = roomController.getAvailableRooms();
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

    private void styleButton(JButton btn) {
        btn.setBackground(Color.black);
        btn.setForeground(Color.white);
        btn.setFont(new Font("Serif", Font.BOLD, 16));
    }

    public static void main(String[] args) {
        new AllRoomsInfoPanel();
    }
}
