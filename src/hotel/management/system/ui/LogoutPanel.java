package hotel.management.system.ui;

import hotel.management.system.controller.LoginController;
import hotel.management.system.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LogoutPanel extends JFrame implements ActionListener {

    JTextField namef;
    JTextField passf;
    JButton Login;
    JButton Cancel;



    public LogoutPanel() {

        setLayout(null);
        setBounds(600, 300, 600, 350);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Labels
        JLabel name = new JLabel("Username");
        name.setBounds(50, 50, 100, 30);
        JLabel pass = new JLabel("Password");
        pass.setBounds(50, 115, 100, 30);
        add(pass);
        add(name);

        //Textfields
        namef = new JTextField();
        namef.setBounds(200, 50, 200, 30);
        add(namef);
        passf = new JTextField();
        passf.setBounds(200, 115, 200, 30);
        add(passf);

        //Buttons
        Cancel = new JButton("Cancel");
        Cancel.setBounds(75, 200, 100, 30);
        add(Cancel);
        Cancel.addActionListener(this);
        Login = new JButton("Login");
        Login.setBounds(250, 200, 100, 30);
        add(Login);
        Login.addActionListener(this);

        //Images
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(435, 50, 120, 150);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Login) {
            
            LoginController loginController = new LoginController();
           
            
            
            User user = new User(
                    namef.getText(),
                    passf.getText()                 
            );

            if(loginController.userLogin(user)){
                
                setVisible(false);
                add(new DashBoard());

            }
            else{
                    
                JOptionPane.showMessageDialog(
                        null, "Invalid credentials"
                );
            }

        }

        if (e.getSource() == Cancel) {
            setVisible(false);
        }

    }

}
