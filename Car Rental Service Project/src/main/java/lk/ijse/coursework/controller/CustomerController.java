package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CustomerDTO;
import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.service.CustomerService;
import lk.ijse.coursework.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto){
        if (dto.getCusID().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerService.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(path = "/search/{cusID}")
    public ResponseEntity searchCustomerForLogin(@PathVariable String cusID){
        System.out.println(cusID+"id eka enwa");
        CustomerDTO dto = customerService.searchCustomer(cusID);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);


    }



    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto){
        boolean done = customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);

    }


    @DeleteMapping(path = "/delete/{cusID}")
    public ResponseEntity deleteCustomer(@PathVariable String cusID) {
        System.out.println(cusID+"controller");
        boolean done = customerService.deleteCustomer(cusID);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }




}
