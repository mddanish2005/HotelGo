package hotel.management.system.ui.auth;

import hotel.management.system.ui.dashboard.DashBoard;
import hotel.management.system.controller.UserController;
import hotel.management.system.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton cancelButton;

    public LoginPanel() {

        setLayout(null);
        setBounds(520, 260, 700, 420);
        getContentPane().setBackground(new Color(242, 242, 242));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login | Hotel Management System");

        JLabel heading = new JLabel("User Login");
        heading.setBounds(60, 25, 300, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(60, 60, 60));
        add(heading);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 105, 140, 30);
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 165, 140, 30);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(230, 105, 240, 36);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(230, 165, 240, 36);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(230, 235, 110, 40);
        loginButton.setBackground(new Color(33, 150, 243));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(loginButton);
        loginButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(360, 235, 110, 40);
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cancelButton.setFocusPainted(false);
        add(cancelButton);
        cancelButton.addActionListener(this);

        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/login.jpg")
        );
        Image scaledImage = icon.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(scaledImage));
        image.setBounds(500, 110, 190, 190);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            UserController userController = new UserController();

            User user = new User(
                    usernameField.getText(),
                    new String(passwordField.getPassword())
            );

            if (userController.userLogin(user)) {
                dispose();
                add(new DashBoard());
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid credentials - Try again",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }
}
