package hotel.management.system;

import hotel.management.system.ui.LoginPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
     JLabel image;
     JLabel text;

    public HotelManagementSystem() {

        setTitle("Hotel Management System");
         setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        image = new JLabel();
        image.setLayout(null);
        add(image,BorderLayout.CENTER);
        

        text = new JLabel("Hotel Management System");
        text.setBounds(150, 30, 900, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif", Font.BOLD, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(450, 850, 150, 45);
        next.setFont(new Font("Serif", Font.ITALIC, 25));
        next.addActionListener(this);
        image.add(next);

       
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/first.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(
                getWidth(),
                getHeight(),
                Image.SCALE_SMOOTH
        );
        image.setIcon(new ImageIcon(i2));
        
         setVisible(true);
        startBlinkingText();
    }


    
    private void startBlinkingText() {
        Timer timer = new Timer(350, new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setVisible(visible);
                visible = !visible;
            }
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
