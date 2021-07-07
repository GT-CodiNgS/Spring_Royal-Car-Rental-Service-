package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CustomerDTO;

import java.util.ArrayList;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface CustomerService {
    boolean addCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String id);

    boolean deleteCustomer(String id);



    boolean updateCustomer(CustomerDTO dto);

    ArrayList<CustomerDTO> getAllCustomers();

}
