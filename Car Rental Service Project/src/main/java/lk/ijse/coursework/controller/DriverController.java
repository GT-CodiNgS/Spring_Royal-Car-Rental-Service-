package lk.ijse.coursework.controller;


import lk.ijse.coursework.dto.DriverDTO;
import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.service.DriverService;
import lk.ijse.coursework.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Gayash Thasmika
 * @date:6/22/2021
 * @since : 0.0.1
 **/
@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Driver id cannot be empty");
        }
        service.addDriver(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(path = "/search/{id}")
    public ResponseEntity searchDriver(@PathVariable String id){
        System.out.println(id+"id eka enwa");
        DriverDTO dto = service.searchDriver(id);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);


    }



    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto){
        boolean done = service.updateDriver(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);

    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteDriver(@PathVariable String id) {
        System.out.println(id+"controller");
        boolean done = service.deleteDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> allDrivers = service.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", allDrivers), HttpStatus.OK);
    }

}
