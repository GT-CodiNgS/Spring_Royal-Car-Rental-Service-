package lk.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Driver {
    @Id
    private String id;
    private String name;
    private String dob;
    private String li_no;
    private String nic_no;
    private String contact;





}
