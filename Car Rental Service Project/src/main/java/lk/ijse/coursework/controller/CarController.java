package lk.ijse.coursework.controller;


import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.service.CarService;
import lk.ijse.coursework.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    public CarService carService;

    @PostMapping
    public ResponseEntity saveCar(@RequestBody CarDTO dto){
        System.out.println(dto+"controller");
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Car id cannot be empty");
        }
        carService.addCar(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity searchCar(@PathVariable String id){
        CarDTO dto = carService.searchCar(id);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);


    }



    @PutMapping
    public ResponseEntity updateCar(@RequestBody CarDTO dto){
        boolean done = carService.updateCar(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);

    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable String id) {
        System.out.println(id+"controller");
        boolean done = carService.deleteCar(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity getAllCars() {
        ArrayList<CarDTO> allCars = carService.getAllCars();
        return new ResponseEntity(new StandardResponse("200", "Done", allCars), HttpStatus.OK);
    }

//     get Car By Luxury Type
    @GetMapping(path = "/luxury/{id}")
    public ResponseEntity getAllByType(@PathVariable String id) {
        List<CarDTO> allCars = carService.getCarByLuxuryType(id);
        return new ResponseEntity(new StandardResponse("200", "Done", allCars), HttpStatus.OK);
    }

}
