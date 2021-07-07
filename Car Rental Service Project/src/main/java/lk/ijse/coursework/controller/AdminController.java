package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.AdminDTO;
import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.service.AdminService;
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
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping
    public ResponseEntity saveAdmin(@RequestBody AdminDTO dto){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Admin id cannot be empty");
        }
        service.addAdmin(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(path = "/search/{id}")
    public ResponseEntity searchAdmin(@PathVariable String id){
        System.out.println(id+"id eka enwa");
        AdminDTO dto = service.searchAdmin(id);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);


    }



    @PutMapping
    public ResponseEntity updateAdmin(@RequestBody AdminDTO dto){
        boolean done = service.updateAdmin(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);

    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteAdmin(@PathVariable String id) {
        System.out.println(id+"controller");
        boolean done = service.deleteAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity getAllAdmins() {
        ArrayList<AdminDTO> allAdmins = service.getAllAdmins();
        return new ResponseEntity(new StandardResponse("200", "Done", allAdmins), HttpStatus.OK);
    }



}
