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
public class Customer {
    @Id
    private String cusID;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String licenseNo;
    private String nicNo;
    private String pw;

}
