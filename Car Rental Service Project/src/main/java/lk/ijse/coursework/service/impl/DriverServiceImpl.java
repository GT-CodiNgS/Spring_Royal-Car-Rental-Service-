package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.DriverDTO;
import lk.ijse.coursework.entity.Driver;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.repo.DriverRepo;
import lk.ijse.coursework.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addDriver(DriverDTO dto) {

        if (repo.existsById(dto.getId())) {
            throw new ValidateException("Customer Already Exist");
        }
        repo.save(mapper.map(dto, Driver.class));
        return true;
    }

    @Override
    public DriverDTO searchDriver(String id) {

        Optional<Driver> driver = repo.findById(id);
        if (driver.isPresent()) {
            return mapper.map(driver.get(), DriverDTO.class);
        }

        return null;
    }

    @Override
    public boolean deleteDriver(String id) {


        if (!repo.existsById(id)) {
            throw new ValidateException("No Driver for Delete..!");
        }

        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getId())){
            repo.save(mapper.map(dto, Driver.class));
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> drivers = repo.findAll();
        return mapper.map(drivers, new TypeToken<ArrayList<DriverDTO>>() {}.getType());
    }
}
