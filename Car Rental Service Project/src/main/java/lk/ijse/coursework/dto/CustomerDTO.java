package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private String cusID;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String licenseNo;
    private String nicNo;
    private String pw;

}
