
package hotel.management.system.ui;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DashBoard extends JFrame implements ActionListener  {
    
    JMenuItem addEmployee;
    JMenuItem addDriver;
    JMenuItem addRoom;
    JMenuItem reception;

    public DashBoard() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        

        //Menu Bar
        
        JMenuBar mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(0, 40));
        setJMenuBar(mb);

        Font menuFont = new Font("Segoe UI", Font.PLAIN, 18);

        JMenu hm = new JMenu("Hotel Management");
        hm.setFont(menuFont);
        hm.setForeground(Color.RED);
        mb.add(hm);

        JMenu admin = new JMenu("Admin");
        admin.setFont(menuFont);
        mb.add(admin);

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
        
        admin.add(addRoom);
        admin.add(addDriver);
        admin.add(addEmployee);
        hm.add(reception);
        reception.addActionListener(this);
        //Background image
        JLabel image1 = new JLabel();
        image1.setLayout(null);
        add(image1, BorderLayout.CENTER);

        //Text heading
        JLabel text1 = new JLabel("The Taj Group Welcomes You");
        text1.setBounds(550, 60, 1000, 70);
        text1.setFont(new Font("tahoma", Font.CENTER_BASELINE, 60));
        text1.setForeground(Color.white);
        image1.add(text1);

        setVisible(true);

        //Image Scaling
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/third.jpg")
        );

        Image i2 = i1.getImage().getScaledInstance(
                getContentPane().getWidth(),
                getContentPane().getHeight(),
                Image.SCALE_SMOOTH
        );

        image1.setIcon(new ImageIcon(i2));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == addEmployee)
       {
           new EmployeePanel();
           
       }
       if(e.getActionCommand().equals("Add Room"))
       {
           new RoomPanel();
    
       }
       if(e.getSource() == addDriver)
       {
          new DriverPanel();
     
       }
       if(e.getSource() == reception)
       {
          new ReceptionPanel();
          
       }
    }


 

}
