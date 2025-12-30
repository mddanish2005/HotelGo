package hotel.management.system.ui.reception;

import hotel.management.system.controller.CustomerController;
import hotel.management.system.model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AllCustomersInfoPanel extends JFrame {

    JTextField searchField;
    JButton searchBtn, backBtn, showAllBtn;

    JTable table;
    DefaultTableModel model;

    CustomerController customerController = new CustomerController();

    public AllCustomersInfoPanel() {

        setLayout(null);
        setBounds(500, 150, 1100, 800);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Customer Information");
        heading.setBounds(380, 20, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 28));
        add(heading);

        // ===== SEARCH =====
        JLabel searchLabel = new JLabel("Search by Name:");
        searchLabel.setBounds(50, 80, 150, 30);
        searchLabel.setFont(new Font("serif", Font.BOLD, 16));
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(200, 80, 200, 30);
        add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(420, 80, 120, 30);
        searchBtn.setBackground(Color.black);
        searchBtn.setForeground(Color.white);
        add(searchBtn);

        showAllBtn = new JButton("Show All");
        showAllBtn.setBounds(560, 80, 120, 30);
        showAllBtn.setBackground(Color.gray);
        showAllBtn.setForeground(Color.white);
        add(showAllBtn);

        // ===== BACK BUTTON =====
        backBtn = new JButton("Back");
        backBtn.setBounds(900, 30, 120, 35);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        // ===== TABLE =====
        String[] columns = {
                "Customer ID",
                "ID Type",
                "ID Number",
                "Name",
                "Gender",
                "Country",
                "Room No",
                "Check-In Time",
                "Deposit"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 140, 980, 600);
        add(scrollPane);

        // ===== ACTIONS =====
        searchBtn.addActionListener(e -> searchCustomer());
        showAllBtn.addActionListener(e -> loadAllCustomers());

        // Load all initially
        loadAllCustomers();

        setVisible(true);
    }

    private void loadAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        populateTable(customers);
    }

    private void searchCustomer() {
        String name = searchField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter customer name");
            return;
        }
        List<Customer> customers = customerController.getCustomerByName(name);
        populateTable(customers);
    }

    private void populateTable(List<Customer> customers) {
        model.setRowCount(0);
        for (Customer c : customers) {
            model.addRow(new Object[]{
                    c.getCustomerId(),
                    c.getIdType(),
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

    public static void main(String[] args) {
        new AllCustomersInfoPanel();
    }
}
