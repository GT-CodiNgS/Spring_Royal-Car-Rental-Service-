package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.BookingDTO;
import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.service.BookingService;
import lk.ijse.coursework.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/22/2021
 * @since : 0.0.1
 **/
@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity saveBooking(@RequestBody BookingDTO dto){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Booking id cannot be empty");
        }
        service.addBooking(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(path = "/search/{id}")
    public ResponseEntity searchBooking(@PathVariable String id){
        System.out.println(id+"id eka enwa");
        BookingDTO dto = service.searchBooking(id);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);


    }



    @PutMapping
    public ResponseEntity updateBooking(@RequestBody BookingDTO dto){
        boolean done = service.updateBooking(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);

    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBooking(@PathVariable String id) {
        System.out.println(id+"controller");
        boolean done = service.deleteBooking(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity getAllBookings() {
        ArrayList<BookingDTO> allBookings = service.getAllBooking();
        return new ResponseEntity(new StandardResponse("200", "Done", allBookings), HttpStatus.OK);
    }

//    pending values
    @GetMapping(path = "/getPending/{id}")
    public ResponseEntity getAllPermissionPending(@PathVariable String id) {
        System.out.println(id);
        List<BookingDTO> allBookings = service.getPendingBookings(id);
        return new ResponseEntity(new StandardResponse("200", "Done", allBookings), HttpStatus.OK);
    }

    @GetMapping(path = "/bcount/{id}")
    public ResponseEntity getAllBookingCount_ofDay(@PathVariable String id) {
        System.out.println(id);
        List<BookingDTO> allBookings = service.getBookingCount_ofDay(id);
        return new ResponseEntity(new StandardResponse("200", "Done", allBookings), HttpStatus.OK);
    }


}
