package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.DriverDTO;

import java.util.ArrayList;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface DriverService {
    boolean addDriver(DriverDTO dto);

    DriverDTO searchDriver(String id);

    boolean deleteDriver(String id);



    boolean updateDriver(DriverDTO dto);

    ArrayList<DriverDTO> getAllDrivers();
}
