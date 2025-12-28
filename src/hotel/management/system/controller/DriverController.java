package hotel.management.system.controller;

import hotel.management.system.dao.DriverDAO;
import hotel.management.system.model.Driver;
import java.sql.SQLException;

public class DriverController {

    DriverDAO driverDao = new DriverDAO();

    public boolean addDriver(Driver dv) {

        try {
            return driverDao.addDriver(dv);
        } catch (SQLException ex) {
            System.getLogger(EmployeeController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}
