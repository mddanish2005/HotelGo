package hotel.management.system.ui.admin;

import hotel.management.system.controller.DepartmentController;
import hotel.management.system.controller.EmployeeController;
import hotel.management.system.dao.DepartmentDAO;
import hotel.management.system.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AddEmployeePanel extends JFrame implements ActionListener {

    JButton submitButton, backButton;

    JLabel nameLabel, ageLabel, genderLabel, jobLabel, departmentLabel, salaryLabel, phoneLabel;

    JTextField nameField, ageField, salaryField, phoneField, jobField;

    JRadioButton maleRadio, femaleRadio;
    ButtonGroup genderGroup;

    JComboBox departmentComboBox;

    DepartmentDAO departmentDao = new DepartmentDAO();
    public AddEmployeePanel() {

        setLayout(null);
        setBounds(500, 240, 920, 670);
        getContentPane().setBackground(new Color(242, 242, 242));
        setTitle("Add Employee");

        JLabel heading = new JLabel("Add New Employee");
        heading.setBounds(60, 20, 400, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(60, 60, 60));
        add(heading);

        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        salaryLabel = new JLabel("Salary");
        phoneLabel = new JLabel("Phone");
        genderLabel = new JLabel("Gender");
        departmentLabel = new JLabel("Department");

        int y = 90;
        JLabel[] labels = {nameLabel, ageLabel, salaryLabel, phoneLabel, genderLabel, departmentLabel};
        for (JLabel l : labels) {
            l.setBounds(80, y, 160, 30);
            l.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            add(l);
            y += 65;
        }

        jobLabel = new JLabel("Job");
        jobLabel.setBounds(470, 420, 100, 30);
        jobLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(jobLabel);

        nameField = new JTextField();
        ageField = new JTextField();
        salaryField = new JTextField();
        phoneField = new JTextField();

        JTextField[] fields = {nameField, ageField, salaryField, phoneField};
        int y2 = 90;
        for (JTextField f : fields) {
            f.setBounds(270, y2, 180, 34);
            f.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            add(f);
            y2 += 65;
        }

        jobField = new JTextField();
        jobField.setBounds(540, 420, 180, 34);
        jobField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(jobField);

        genderGroup = new ButtonGroup();

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(270, 350, 70, 30);
        maleRadio.setBackground(new Color(242, 242, 242));
        maleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(350, 350, 90, 30);
        femaleRadio.setBackground(new Color(242, 242, 242));
        femaleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        add(maleRadio);
        add(femaleRadio);

        String[] departments = departmentDao.getAllDepartmentNames();
        departmentComboBox = new JComboBox(departments);
        departmentComboBox.setBounds(270, 420, 180, 34);
        departmentComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        departmentComboBox.setBackground(Color.WHITE);
        add(departmentComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(330, 520, 140, 45);
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(submitButton);
        submitButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(500, 520, 140, 45);
        backButton.setBackground(new Color(90, 90, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButton.setFocusPainted(false);
        add(backButton);
        backButton.addActionListener(this);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/employee.png"));
        Image img = icon.getImage().getScaledInstance(350, 300, Image.SCALE_FAST);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(510, 90, 350, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployeePanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            EmployeeController employeeController = new EmployeeController();

            Employee emp = new Employee(
                    nameField.getText(),
                    Integer.valueOf(ageField.getText()),
                    BigDecimal.valueOf(Double.parseDouble(salaryField.getText())),
                    phoneField.getText(),
                    maleRadio.isSelected() ? "Male" : "Female",
                    jobField.getText(),
                    (String) departmentComboBox.getSelectedItem()
            );

            if (employeeController.addEmployee(emp)) {
                dispose();
                JOptionPane.showMessageDialog(
                        null, "Employee Added Successfully"
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
