package hotel.management.system.ui;

import hotel.management.system.model.Customer;
import hotel.management.system.controller.CustomerController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerInfoPanel extends JFrame implements ActionListener {

    JTextField nameField;
    JButton search;

    JTable table;
    DefaultTableModel model;

    CustomerController customerController = new CustomerController();

    public CustomerInfoPanel() {

        setLayout(null);
        setBounds(500, 150, 1000, 800);
        getContentPane().setBackground(Color.white);

        JLabel enterName = new JLabel("Enter Customer Name");
        enterName.setBounds(300, 50, 300, 50);
        enterName.setFont(new Font("serif", Font.BOLD, 20));
        add(enterName);

        nameField = new JTextField();
        nameField.setBounds(300, 100, 200, 30);
        add(nameField);

        search = new JButton("Search");
        search.setBounds(500, 100, 200, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.setFont(new Font("serif", Font.BOLD, 18));
        search.addActionListener(this);
        add(search);

        // ===== TABLE =====
        String[] columns = {
                "ID", "ID Number", "Name", "Gender",
                "Country", "Room No", "Check In Time", "Deposit"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setBounds(50, 200, 900, 400);

        add(table);

        setVisible(true);
    }

    private void showDetails(List<Customer> customers) {

        model.setRowCount(0); // clear previous data

        for (Customer c : customers) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getIdNumber(),
                    c.getName(),
                    c.getGender(),
                    c.getCountry(),
                    c.getRoomNo(),
                    c.getCheckInTime(),
                    c.getDeposit()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search) {
            List<Customer> customers =
                    customerController.getCustomerByName(nameField.getText().trim());

            showDetails(customers);
        }
    }

    public static void main(String[] args) {
        new CustomerInfoPanel();
    }
}
