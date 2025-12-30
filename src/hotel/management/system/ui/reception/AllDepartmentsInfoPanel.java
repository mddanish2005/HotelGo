package hotel.management.system.ui.reception;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import hotel.management.system.dao.DepartmentDAO;
import hotel.management.system.model.DepartmentStats;

public class AllDepartmentsInfoPanel extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton backBtn;

    DepartmentDAO departmentDao= new DepartmentDAO();

    public AllDepartmentsInfoPanel() {

        setLayout(null);
        setBounds(500, 150, 900, 700);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Department Overview");
        heading.setBounds(280, 30, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 28));
        add(heading);

        // Back button
        backBtn = new JButton("Back");
        backBtn.setBounds(40, 30, 120, 35);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        // Table
        String[] columns = {
                "Department Name",
                "Budget",
                "No. of Employees"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBounds(50, 120, 780, 450);
add(scrollPane);


        loadDepartments();

        setVisible(true);
    }

    private void loadDepartments() {
        List<DepartmentStats> list = departmentDao.getDepartmentsStats();
        model.setRowCount(0);

        for (DepartmentStats d : list) {
            model.addRow(new Object[]{
                    d.getDepartmentName(),
                    d.getBudget(),
                    d.getEmployeeCount()
            });
        }
    }
}
