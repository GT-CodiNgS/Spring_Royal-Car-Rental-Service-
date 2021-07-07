package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface AdminRepo extends JpaRepository<Admin,String> {
}
