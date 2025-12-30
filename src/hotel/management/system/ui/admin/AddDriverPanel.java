package hotel.management.system.ui.admin;

import hotel.management.system.controller.DriverController;
import hotel.management.system.model.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AddDriverPanel extends JFrame implements ActionListener {

    JButton submitButton, backButton;

    JLabel nameLabel, ageLabel, genderLabel, availabilityLabel, carModelLabel, carCompanyLabel, locationLabel;

    JTextField nameField, ageField, carModelField, carCompanyField, locationField;

    JRadioButton maleRadio, femaleRadio;
    ButtonGroup genderGroup;

    JComboBox availabilityComboBox;

    public AddDriverPanel() {

        setLayout(null);
        setBounds(500, 240, 920, 670);
        getContentPane().setBackground(new Color(242, 242, 242));
        setTitle("Add Driver");

        JLabel heading = new JLabel("Add New Driver");
        heading.setBounds(60, 20, 400, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(60, 60, 60));
        add(heading);

        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        carModelLabel = new JLabel("Car Model");
        carCompanyLabel = new JLabel("Car Company");
        locationLabel = new JLabel("Location");
        genderLabel = new JLabel("Gender");
        availabilityLabel = new JLabel("Availability");

        int y = 90;
        JLabel[] labels = {
                nameLabel,
                ageLabel,
                carModelLabel,
                carCompanyLabel,
                locationLabel,
                genderLabel,
                availabilityLabel
        };

        for (JLabel l : labels) {
            l.setBounds(80, y, 160, 30);
            l.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            add(l);
            y += 65;
        }

        nameField = new JTextField();
        ageField = new JTextField();
        carModelField = new JTextField();
        carCompanyField = new JTextField();
        locationField = new JTextField();

        JTextField[] fields = {
                nameField,
                ageField,
                carModelField,
                carCompanyField,
                locationField
        };

        int y2 = 90;
        for (JTextField f : fields) {
            f.setBounds(270, y2, 180, 34);
            f.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            add(f);
            y2 += 65;
        }

        genderGroup = new ButtonGroup();

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(270, 410, 70, 30);
        maleRadio.setBackground(new Color(242, 242, 242));
        maleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(350, 410, 90, 30);
        femaleRadio.setBackground(new Color(242, 242, 242));
        femaleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        add(maleRadio);
        add(femaleRadio);

        availabilityComboBox = new JComboBox(new String[]{"Available", "Occupied"});
        availabilityComboBox.setBounds(270, 475, 180, 34);
        availabilityComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        availabilityComboBox.setBackground(Color.WHITE);
        add(availabilityComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(330, 540, 140, 45);
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(submitButton);
        submitButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(500, 540, 140, 45);
        backButton.setBackground(new Color(90, 90, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButton.setFocusPainted(false);
        add(backButton);
        backButton.addActionListener(this);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
        Image img = icon.getImage().getScaledInstance(420, 418, Image.SCALE_FAST);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(470, 90, 420, 418);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddDriverPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            DriverController driverController = new DriverController();

            Driver dv = new Driver(
                    nameField.getText(),
                    Integer.valueOf(ageField.getText()),
                    carModelField.getText(),
                    carCompanyField.getText(),
                    locationLabel.getText(),
                    maleRadio.isSelected() ? "Male" : "Female",
                    (String) availabilityComboBox.getSelectedItem()
            );

            if (driverController.addDriver(dv)) {
                dispose();
                JOptionPane.showMessageDialog(
                        null, "Driver Added Successfully"
                );
            } else {
                JOptionPane.showMessageDialog(
                        null, "Invalid Details - try again"
                );
            }
        }

        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
