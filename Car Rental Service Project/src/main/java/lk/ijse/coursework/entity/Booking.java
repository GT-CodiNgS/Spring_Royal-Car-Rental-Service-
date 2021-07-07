package lk.ijse.coursework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    @Id
    private String id;
    private String driver;
    private String pickupDate;
    private String returnDate;
    private String location;
    private String permission;
    @ManyToOne
    @JoinColumn(name = "customer" ,referencedColumnName = "cusID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car",referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_ID",referencedColumnName = "id")
    private Driver driver_ID;





}
