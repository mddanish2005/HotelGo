package hotel.management.system.ui.reception;

import hotel.management.system.controller.CustomerController;
import hotel.management.system.model.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CheckOutPanel extends JFrame implements ActionListener {

    private JTextField idNumberField;
    private JLabel nameValue;
    private JLabel roomValue;
    private JLabel checkInValue;
    private JLabel totalBillValue;
    private JLabel depositValue;
    private JLabel pendingValue;

    private JButton loadBtn;
    private JButton checkoutBtn;
    private JButton backBtn;

    CustomerController customerController = new CustomerController();
    Customer customer;
    BigDecimal pending;

    public CheckOutPanel() {

        setTitle("Guest Check-Out");
        setBounds(420, 180, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Guest Check-Out");
        heading.setBounds(60, 30, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 32));
        add(heading);

        JLabel idLabel = new JLabel("Government ID Number");
        idLabel.setBounds(60, 100, 220, 30);
        idLabel.setFont(new Font("Serif", Font.BOLD, 17));
        add(idLabel);

        idNumberField = new JTextField();
        idNumberField.setBounds(300, 100, 220, 32);
        add(idNumberField);

        loadBtn = new JButton("Load");
        loadBtn.setBounds(540, 100, 100, 32);
        styleButton(loadBtn);
        add(loadBtn);
        loadBtn.addActionListener(this);

        addInfoLabel("Name", 170);
        addInfoLabel("Room Number", 220);
        addInfoLabel("Check-In Time", 270);
        addInfoLabel("Total Bill", 320);
        addInfoLabel("Deposit Paid", 370);
        addInfoLabel("Pending Amount", 420);

        nameValue = addValueLabel(170);
        roomValue = addValueLabel(220);
        checkInValue = addValueLabel(270);
        totalBillValue = addValueLabel(320);
        depositValue = addValueLabel(370);
        pendingValue = addValueLabel(420);

        checkoutBtn = new JButton("Confirm Check-Out");
        checkoutBtn.setBounds(300, 480, 200, 45);
        styleButton(checkoutBtn);
        add(checkoutBtn);
        checkoutBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(520, 480, 120, 45);
        styleButton(backBtn);
        add(backBtn);
        backBtn.addActionListener(this);

        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/checkout.jpg")
        );
        Image img = icon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(520, 160, 350, 350);
        add(image);

        setVisible(true);
    }

    private void addInfoLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(60, y, 220, 30);
        label.setFont(new Font("Serif", Font.BOLD, 17));
        add(label);
    }

    private JLabel addValueLabel(int y) {
        JLabel label = new JLabel("-");
        label.setBounds(300, y, 220, 30);
        label.setFont(new Font("Serif", Font.PLAIN, 17));
        add(label);
        return label;
    }

    private void styleButton(JButton btn) {
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Serif", Font.BOLD, 16));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            dispose();
        }

        if (e.getSource() == loadBtn) {

            String govtId = idNumberField.getText().trim();

            if (govtId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter government ID number");
                return;
            }

            customer
                    = customerController.getCustomerByGovernmentId(govtId);

            if (customer == null) {
                JOptionPane.showMessageDialog(this, "Customer not found");
                return;
            }

            nameValue.setText(customer.getName());
            roomValue.setText(customer.getRoomNo());
            checkInValue.setText(customer.getCheckInTime().toString());
            totalBillValue.setText(customer.getTotalBill().toString());
            depositValue.setText(customer.getDeposit().toString());

           pending
                    = customer.getTotalBill().subtract(customer.getDeposit());

            pendingValue.setText(pending.toString());
        }

        if (e.getSource() == checkoutBtn) {

            if (!(pendingValue.getText().equals("0.00"))) {
                JOptionPane.showMessageDialog(this, "Please settle payment");
                return;
            } else {
                if (customerController.checkOutCustomer(customer)) {
                    JOptionPane.showMessageDialog(this, "Bye bye");
                    dispose();                  
                } else {
                    JOptionPane.showMessageDialog(this, "Error occured");
                }

            }
        }
    }

    public static void main(String[] args) {
        new CheckOutPanel();
    }
}
