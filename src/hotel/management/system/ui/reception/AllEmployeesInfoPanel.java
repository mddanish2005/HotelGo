package hotel.management.system.ui.reception;

import hotel.management.system.controller.EmployeeController;
import hotel.management.system.model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AllEmployeesInfoPanel extends JFrame {

    JTable table;
    DefaultTableModel model;

    JButton backBtn;

    EmployeeController employeeController = new EmployeeController();

    public AllEmployeesInfoPanel() {

        setLayout(null);
        setBounds(420, 130, 1100, 820);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Employee Directory");
        heading.setBounds(420, 35, 500, 45);
        heading.setFont(new Font("Serif", Font.BOLD, 32));
        add(heading);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 40, 120, 38);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("Serif", Font.BOLD, 16));
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        String[] columns = {
                "ID", "Name", "Age", "Salary",
                "Phone", "Gender", "Job", "Department", "Created At"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        table.setRowHeight(28);
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 980, 600);
        add(scrollPane);

        loadEmployees();
        setVisible(true);
    }

    private void loadEmployees() {
        List<Employee> emps = employeeController.getAllEmployee();
        model.setRowCount(0);

        for (Employee e : emps) {
            model.addRow(new Object[]{
                    e.getEmpId(),
                    e.getName(),
                    e.getAge(),
                    e.getSalary(),
                    e.getPhone(),
                    e.getGender(),
                    e.getJob(),
                    e.getDepartmentName(),
                    e.getCreatedAt()
            });
        }
    }

    public static void main(String[] args) {
        new AllEmployeesInfoPanel();
    }
}
