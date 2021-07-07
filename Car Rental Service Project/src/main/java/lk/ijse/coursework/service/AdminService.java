package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.AdminDTO;
import lk.ijse.coursework.dto.CarDTO;

import java.util.ArrayList;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface AdminService {
    boolean addAdmin(AdminDTO dto);

    AdminDTO searchAdmin(String id);

    boolean deleteAdmin(String id);



    boolean updateAdmin(AdminDTO dto);

    ArrayList<AdminDTO> getAllAdmins();
}
