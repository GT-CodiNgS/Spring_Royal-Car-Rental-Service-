package lk.ijse.coursework.repo;


import lk.ijse.coursework.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface CarRepo extends JpaRepository<Car,String> {
    List<Car> findByTypeEquals(String id);
}

