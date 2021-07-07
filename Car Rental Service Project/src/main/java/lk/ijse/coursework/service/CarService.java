package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.BookingDTO;
import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.entity.Car;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface CarService  {
    boolean addCar(CarDTO dto);

    CarDTO searchCar(String id);

    boolean deleteCar(String id);


    boolean updateCar(CarDTO dto);

    ArrayList<CarDTO> getAllCars();

//    *************

    List<CarDTO> getCarByLuxuryType(String name);
}
