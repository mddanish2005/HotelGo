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

    DepartmentDAO departmentDao = new DepartmentDAO();

    public AllDepartmentsInfoPanel() {

        setLayout(null);
        setBounds(420, 140, 1000, 760);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Department Overview");
        heading.setBounds(350, 30, 500, 45);
        heading.setFont(new Font("Serif", Font.BOLD, 32));
        add(heading);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 35, 120, 38);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("Serif", Font.BOLD, 16));
        backBtn.addActionListener(e -> dispose());
        add(backBtn);

        String[] columns = {
                "Department Name",
                "Budget",
                "Employees"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        table.setRowHeight(30);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 900, 560);
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
