package lk.ijse.coursework.dto;

import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.entity.Customer;
import lk.ijse.coursework.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {
    private String id;
    private String driver;
    private String pickupDate;
    private String returnDate;
    private String location;
    private String permission;
    private Customer customer;
    private Car car;
    private Driver driver_ID;

}
