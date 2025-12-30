package hotel.management.system.ui.reception;

import hotel.management.system.controller.CustomerController;
import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Customer;
import hotel.management.system.model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

public class NewCheckinPanel extends JFrame implements ActionListener {

    private JButton submitBtn, backBtn;

    private JTextField govtIdNumberField, nameField, countryField, depositField;
    private JComboBox<String> govtIdTypeComboBox, roomNoComboBox;

    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;

    private JLabel showCheckInTimeLabel;
    private JLabel totalBillLabel;

    private final RoomController roomController = new RoomController();
    private final CustomerController customerController = new CustomerController();

    public NewCheckinPanel() {

        setTitle("New Customer Check-In");
        setBounds(400, 150, 1200, 720);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        addFormLabels();
        addFormInputs();
        addButtons();
        addImage();
        setVisible(true);
    }

    private void addFormLabels() {

        addLabel("Govt ID Type", 80);
        addLabel("Govt ID Number", 150);
        addLabel("Name", 220);
        addLabel("Gender", 290);
        addLabel("Country", 360);
        addLabel("Allocate Room", 430);
        addLabel("Check-in Time", 500);
        addLabel("Deposit", 570);
        totalBillLabel = new JLabel("0.00");
        totalBillLabel.setBounds(300, 540, 200, 30);
        totalBillLabel.setFont(new Font("Serif", Font.BOLD, 16));
        add(totalBillLabel);

        showCheckInTimeLabel = new JLabel(new Date().toString());
        showCheckInTimeLabel.setBounds(300, 500, 300, 30);
        showCheckInTimeLabel.setFont(new Font("Serif", Font.BOLD, 15));
        add(showCheckInTimeLabel);
    }

    private void addFormInputs() {

        govtIdTypeComboBox = new JComboBox<>(new String[]{"Passport", "Aadhar"});
        govtIdTypeComboBox.setBounds(300, 80, 200, 32);
        add(govtIdTypeComboBox);

        govtIdNumberField = addTextField(150);
        nameField = addTextField(220);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");

        maleRadio.setBounds(300, 290, 80, 30);
        femaleRadio.setBounds(400, 290, 100, 30);
        maleRadio.setBackground(Color.WHITE);
        femaleRadio.setBackground(Color.WHITE);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        add(maleRadio);
        add(femaleRadio);

        countryField = addTextField(360);

        roomNoComboBox = new JComboBox<>(roomController.getAvailableRoomNos());
        roomNoComboBox.setBounds(300, 430, 200, 32);
        add(roomNoComboBox);
        roomNoComboBox.addActionListener(e -> {

            String roomNo = (String) roomNoComboBox.getSelectedItem();

            if (roomNo != null) {
                totalBillLabel.setText(String.valueOf(roomController.getRoomPrice(roomNo)));
            }
        });

        depositField = addTextField(570);
    }

    private void addButtons() {

        submitBtn = createButton("Submit", 650, 580);
        backBtn = createButton("Back", 820, 580);

        add(submitBtn);
        add(backBtn);

        submitBtn.addActionListener(this);
        backBtn.addActionListener(this);
    }

    private void addImage() {

        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/checkin.jpg")
        );

        Image img = icon.getImage().getScaledInstance(450, 400, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(650, 80, 500, 450);
        add(imageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {
            BigDecimal totalBill
                    = roomController.getRoomPrice((String) roomNoComboBox.getSelectedItem());

            BigDecimal deposit = new BigDecimal(depositField.getText());

            if (deposit.compareTo(totalBill) > 0) {
                JOptionPane.showMessageDialog(this, "Invalid deposit amount");
            } else {

                Customer customer = new Customer(
                        (String) govtIdTypeComboBox.getSelectedItem(),
                        govtIdNumberField.getText(),
                        nameField.getText(),
                        maleRadio.isSelected() ? "Male" : "Female",
                        countryField.getText(),
                        (String) roomNoComboBox.getSelectedItem(),
                        deposit,
                        totalBill
                );

                if (customerController.addCustomer(customer)) {
                    JOptionPane.showMessageDialog(this, "Customer checked in successfully");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid details, try again");
                }
            }

            if (e.getSource() == backBtn) {
                dispose();
            }
        }
    }

    private void addLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(80, y, 180, 30);
        label.setFont(new Font("Serif", Font.BOLD, 17));
        add(label);
    }

    private JTextField addTextField(int y) {
        JTextField tf = new JTextField();
        tf.setBounds(300, y, 200, 32);
        add(tf);
        return tf;
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 140, 45);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Serif", Font.BOLD, 18));
        return btn;
    }

    public static void main(String[] args) {
        new NewCheckinPanel();
    }
}
