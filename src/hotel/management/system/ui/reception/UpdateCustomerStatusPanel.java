package hotel.management.system.ui.reception;

import hotel.management.system.controller.CustomerController;
import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Customer;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class UpdateCustomerStatusPanel extends JFrame {

    // ===== CONTROLLERS =====
    private final CustomerController customerController = new CustomerController();
    private final RoomController roomController = new RoomController();

    // ===== INPUT =====
    private JTextField idNumberSearchField;
    private JComboBox<String> idTypeComboBox;
    private JTextField customerIdField;
    private JTextField nameField;
    private JTextField genderField;
    private JTextField countryField;
    private JComboBox<String> roomComboBox;
    private JTextField depositField;

    // ===== DISPLAY =====
    private JLabel checkInTimeLabel;
    private JLabel totalBillLabel;
    private JLabel pendingAmountLabel;

    // ===== BUTTONS =====
    private JButton loadBtn, updateBtn, backBtn;

    private Customer loadedCustomer;

    public UpdateCustomerStatusPanel() {

        setTitle("Update Customer Status");
        setBounds(450, 120, 800, 650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        addHeading();
        initSearchSection();
        initFormFields();
        initButtons();

        setVisible(true);
    }

    // ================= UI SECTIONS =================

    private void addHeading() {
        JLabel heading = new JLabel("Update Customer Status");
        heading.setBounds(220, 20, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 26));
        add(heading);
    }

    private void initSearchSection() {
        addLabel("Enter ID No:", 90);
        idNumberSearchField = addTextField(90, true);

        loadBtn = new JButton("Load");
        loadBtn.setBounds(480, 90, 100, 30);
        add(loadBtn);

        loadBtn.addActionListener(e -> loadCustomer());
    }

    private void initFormFields() {

        addLabel("ID Type:", 140);
        idTypeComboBox = new JComboBox<>(new String[]{"Passport", "Aadhar"});
        idTypeComboBox.setBounds(260, 140, 200, 30);
        add(idTypeComboBox);

        addLabel("Customer ID:", 180);
        customerIdField = addTextField(180, false);

        addLabel("Name:", 220);
        nameField = addTextField(220, true);

        addLabel("Gender:", 260);
        genderField = addTextField(260, true);

        addLabel("Country:", 300);
        countryField = addTextField(300, true);

        addLabel("Room No:", 340);
        roomComboBox = new JComboBox<>();
        roomComboBox.setBounds(260, 340, 200, 30);
        add(roomComboBox);

        addLabel("Check-In Time:", 380);
        checkInTimeLabel = createValueLabel(380);

        addLabel("Deposit:", 420);
        depositField = addTextField(420, true);

        addLabel("Total Bill:", 460);
        totalBillLabel = createValueLabel(460);

        addLabel("Pending Amount:", 500);
        pendingAmountLabel = createValueLabel(500);
    }

    private void initButtons() {
        updateBtn = new JButton("Update");
        updateBtn.setBounds(260, 560, 120, 35);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(400, 560, 120, 35);
        add(backBtn);

        updateBtn.addActionListener(e -> updateCustomer());
        backBtn.addActionListener(e -> dispose());
    }

    // ================= LOGIC =================

    private void loadCustomer() {

        String idNo = idNumberSearchField.getText().trim();
        if (idNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter ID number");
            return;
        }

        loadedCustomer = customerController.getCustomerByGovernmentId(idNo);

        if (loadedCustomer == null) {
            JOptionPane.showMessageDialog(this, "Customer not found");
            return;
        }

        customerIdField.setText(String.valueOf(loadedCustomer.getCustomerId()));
        idTypeComboBox.setSelectedItem(loadedCustomer.getIdType());
        nameField.setText(loadedCustomer.getName());
        genderField.setText(loadedCustomer.getGender());
        countryField.setText(loadedCustomer.getCountry());
        depositField.setText(loadedCustomer.getDeposit().toString());

        checkInTimeLabel.setText(loadedCustomer.getCheckInTime().toString());
        totalBillLabel.setText(loadedCustomer.getTotalBill().toString());

        loadRooms(loadedCustomer.getRoomNo());
        updatePending();
    }

    private void updateCustomer() {

        if (loadedCustomer == null) {
            JOptionPane.showMessageDialog(this, "Load customer first");
            return;
        }

        BigDecimal deposit;
        try {
            deposit = new BigDecimal(depositField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid deposit");
            return;
        }

        if (deposit.compareTo(loadedCustomer.getTotalBill()) > 0) {
            JOptionPane.showMessageDialog(this, "Deposit cannot exceed total bill");
            return;
        }

        Customer updated = new Customer(
              
                loadedCustomer.getCustomerId(),
                (String) idTypeComboBox.getSelectedItem(),
                loadedCustomer.getIdNumber(),
                nameField.getText(),
                genderField.getText(),
                countryField.getText(),
                (String) roomComboBox.getSelectedItem(),
                loadedCustomer.getCheckInTime(),
                deposit,
                loadedCustomer.getTotalBill()
        );

        customerController.updateCustomer(updated);
        loadedCustomer = updated;
        updatePending();

        JOptionPane.showMessageDialog(this, "Customer updated successfully");
    }

    private void loadRooms(String currentRoom) {
        roomComboBox.removeAllItems();
        roomComboBox.addItem(currentRoom);
        
        for (String room : roomController.getAvailableRoomNos()) {
            if (!room.equals(currentRoom)) {
                roomComboBox.addItem(room);
            }
        }
    }

    private void updatePending() {
        BigDecimal pending =
                loadedCustomer.getTotalBill().subtract(new BigDecimal(depositField.getText()));
        pendingAmountLabel.setText(pending.toString());
    }

    // ================= HELPERS =================

    private void addLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(120, y, 130, 30);
        label.setFont(new Font("Serif", Font.BOLD, 16));
        add(label);
    }

    private JTextField addTextField(int y, boolean editable) {
        JTextField tf = new JTextField();
        tf.setBounds(260, y, 200, 30);
        tf.setEditable(editable);
        add(tf);
        return tf;
    }

    private JLabel createValueLabel(int y) {
        JLabel label = new JLabel();
        label.setBounds(260, y, 300, 30);
        label.setFont(new Font("Serif", Font.BOLD, 14));
        add(label);
        return label;
    }

    public static void main(String[] args) {
        new UpdateCustomerStatusPanel();
    }
}
