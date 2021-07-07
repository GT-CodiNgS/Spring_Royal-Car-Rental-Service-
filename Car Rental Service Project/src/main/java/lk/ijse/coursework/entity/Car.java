package lk.ijse.coursework.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;



/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car{
    @Id
    private String id;
    private String name;
    private String brand;
    private String color;
    private String type;
    private String passengers;
    private String transmission_Type;
    private String number;
    private String fuelType;
    private String dailyRate;
    private String free_Mileage_day;
    private String monthlyRate;
    private String free_Mileage_month;
    private String extraKmPrice;


}
