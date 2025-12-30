/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.ui.reception;

import hotel.management.system.controller.EmployeeController;
import hotel.management.system.controller.RoomController;
import hotel.management.system.model.Employee;
import hotel.management.system.model.Room;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllEmployeesInfoPanel extends JFrame {

    JTable table;
    DefaultTableModel model;

    JButton backBtn;

    EmployeeController employeeController = new EmployeeController();

    public AllEmployeesInfoPanel() {

        setLayout(null);
        setBounds(500, 150, 1000, 800);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("All Employee Information");
        heading.setBounds(320, 40, 600, 40);
        heading.setFont(new Font("serif", Font.BOLD, 28));
        add(heading);

        // ===== BACK BUTTON =====
        backBtn = new JButton("Back");
        backBtn.setBounds(50, 40, 120, 35);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("serif", Font.BOLD, 16));
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        // ===== TABLE =====
        String[] columns = {
            "ID", "Name", "Age", "Salary",
            "Phone", "Gender", "Job", "Department", "Created at"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 780, 450);
        add(scrollPane);

        loadEmployees();

        setVisible(true);
    }

    public static void main(String[] args) {
        new AllEmployeesInfoPanel();
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
}
