package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Booking;
import lk.ijse.coursework.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface BookingRepo extends JpaRepository<Booking,String> {
    List<Booking> findByPermissionEquals(String id);
    List<Booking> findByPickupDateEquals(String id);


}
