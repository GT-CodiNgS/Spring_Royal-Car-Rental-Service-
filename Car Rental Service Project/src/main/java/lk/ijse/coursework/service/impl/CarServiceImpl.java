package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.repo.CarRepo;
import lk.ijse.coursework.service.CarService;
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
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCar(CarDTO dto) {
        System.out.println(dto+"service");
        if (repo.existsById(dto.getId())) {
            throw new ValidateException("Customer Already Exist");
        }
        repo.save(mapper.map(dto, Car.class));
        return true;
    }

    @Override
    public CarDTO searchCar(String id) {
        Optional<Car> car = repo.findById(id);
        if (car.isPresent()) {
            return mapper.map(car.get(), CarDTO.class);
        }

        return null;
    }

    @Override
    public boolean deleteCar(String id) {

        if (!repo.existsById(id)) {
            throw new ValidateException("No Car for Delete..!");
        }

        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCar(CarDTO dto) {
        if (repo.existsById(dto.getId())){
            repo.save(mapper.map(dto, Car.class));
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> cars = repo.findAll();
        return mapper.map(cars, new TypeToken<ArrayList<CarDTO>>() {}.getType());
    }

    @Override
    public List<CarDTO> getCarByLuxuryType(String id) {
        List<Car> cars = repo.findByTypeEquals(id);
        return mapper.map(cars, new TypeToken<ArrayList<CarDTO>>() {}.getType());
    }


}
