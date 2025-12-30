package hotel.management.system.ui.dashboard;

import hotel.management.system.ui.admin.AddEmployeePanel;
import hotel.management.system.ui.admin.AddDriverPanel;
import hotel.management.system.ui.admin.AddRoomPanel;
import hotel.management.system.ui.reception.ReceptionPanel;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DashBoard extends JFrame implements ActionListener {

    JMenuItem addEmployee;
    JMenuItem addDriver;
    JMenuItem addRoom;
    JMenuItem reception;

    public DashBoard() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLayout(new BorderLayout());

        // ===== Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(0, 42));
        menuBar.setBackground(new Color(245, 245, 245));
        setJMenuBar(menuBar);

        Font menuFont = new Font("Segoe UI", Font.PLAIN, 17);

        JMenu hotelMenu = new JMenu("Hotel Management");
        hotelMenu.setFont(menuFont);
        hotelMenu.setForeground(new Color(178, 34, 34)); // soft red
        menuBar.add(hotelMenu);

        JMenu adminMenu = new JMenu("Admin");
        adminMenu.setFont(menuFont);
        menuBar.add(adminMenu);

        addRoom = new JMenuItem("Add Room");
        addDriver = new JMenuItem("Add Driver");
        addEmployee = new JMenuItem("Add Employee");
        reception = new JMenuItem("Reception");

        addRoom.setFont(menuFont);
        addDriver.setFont(menuFont);
        addEmployee.setFont(menuFont);
        reception.setFont(menuFont);

        addEmployee.addActionListener(this);
        addRoom.addActionListener(this);
        addDriver.addActionListener(this);
        reception.addActionListener(this);

        adminMenu.add(addRoom);
        adminMenu.add(addDriver);
        adminMenu.add(addEmployee);
        hotelMenu.add(reception);

        // ===== Background Image Container =====
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        add(backgroundLabel, BorderLayout.CENTER);

        // ===== Heading Text =====
        JLabel headingText = new JLabel("For Authorized Use Only. All Activities Are Logged and Monitored for Security and Compliance.");
        headingText.setBounds(30, 880, 1740, 80);
        headingText.setFont(new Font("Tahoma", Font.ITALIC, 28));
        headingText.setForeground(Color.WHITE);
        backgroundLabel.add(headingText);

        setVisible(true);

        // ===== Image Scaling =====
        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/dashboard.jpg")
        );

        Image scaledImage = icon.getImage().getScaledInstance(
                getContentPane().getWidth(),
                getContentPane().getHeight(),
                Image.SCALE_FAST
        );

        backgroundLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        new DashBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addEmployee) {
            new AddEmployeePanel();
        }

        if (e.getSource() == addRoom) {
            new AddRoomPanel();
        }

        if (e.getSource() == addDriver) {
            new AddDriverPanel();
        }

        if (e.getSource() == reception) {
            new ReceptionPanel();
        }
    }
}
