/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.controller;

import hotel.management.system.dao.UserDAO;
import hotel.management.system.model.User;
import hotel.management.system.ui.DashBoard;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danish
 */
public class UserController {

    UserDAO userDao = new UserDAO();

    public boolean userLogin(User user) {

        try {

            User userfromdb = userDao.getUser(user.getUserName());

            return userfromdb.getPassword().equals(user.getPassword());

        } catch (SQLException ex) {
            System.getLogger(UserController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;

    }

}
