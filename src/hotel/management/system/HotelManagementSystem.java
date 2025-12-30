package hotel.management.system;

import hotel.management.system.ui.auth.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel image;
    JLabel text;
    float alpha = 0f;

    public HotelManagementSystem() {

        setTitle("Hotel Management System");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
        
        Image bgImage = bgIcon.getImage().getScaledInstance(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height,
                Image.SCALE_FAST
        );

        image = new JLabel(new ImageIcon(bgImage));
        image.setLayout(null);
        add(image, BorderLayout.CENTER);

        JPanel overlay = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };

        overlay.setLayout(null);
        overlay.setOpaque(false);
        
        overlay.setBounds(
                0, 0, 
                Toolkit.getDefaultToolkit().getScreenSize().width, 
                Toolkit.getDefaultToolkit().getScreenSize().height
        );
        image.add(overlay);

        text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(
                0, 200,
                Toolkit.getDefaultToolkit().getScreenSize().width,
                80
        );
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Segoe UI", Font.BOLD, 56));
        text.setForeground(new Color(255, 255, 255, 0));
        overlay.add(text);

        JLabel subtitle = new JLabel("Welcome to a smarter hospitality experience");
        subtitle.setBounds(
                0, 280,
                Toolkit.getDefaultToolkit().getScreenSize().width,
                40
        );
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        subtitle.setForeground(new Color(230, 230, 230));
        overlay.add(subtitle);

        JButton next = new JButton("Get Started");
        next.setBounds(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 100,
                360,
                200,
                50
        );
        next.setFont(new Font("Segoe UI", Font.BOLD, 18));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.addActionListener(this);

        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                next.setBackground(new Color(65, 165, 245));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                next.setBackground(new Color(30, 144, 255));
            }
        });

        overlay.add(next);
        setVisible(true);
        startFadeIn();
    }

    private void startFadeIn() {
        Timer timer = new Timer(40, e -> {
            alpha += 0.05f;
            if (alpha >= 1f) {
                alpha = 1f;
                ((Timer) e.getSource()).stop();
            }
            text.setForeground(
                    new Color(255, 255, 255, (int) (alpha * 255))
            );
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new LoginPanel();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}