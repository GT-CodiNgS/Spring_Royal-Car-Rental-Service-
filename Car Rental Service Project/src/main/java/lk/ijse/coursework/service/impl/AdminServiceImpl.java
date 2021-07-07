package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.AdminDTO;
import lk.ijse.coursework.entity.Admin;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.repo.AdminRepo;
import lk.ijse.coursework.service.AdminService;
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
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addAdmin(AdminDTO dto) {

        if (repo.existsById(dto.getId())) {
            throw new ValidateException("Customer Already Exist");
        }
        repo.save(mapper.map(dto, Admin.class));
        return true;
    }

    @Override
    public AdminDTO searchAdmin(String id) {

        Optional<Admin> admin = repo.findById(id);
        if (admin.isPresent()) {
            return mapper.map(admin.get(), AdminDTO.class);
        }

        return null;
    }

    @Override
    public boolean deleteAdmin(String id) {

        if (!repo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }

        repo.deleteById(id);
        return true;

    }

    @Override
    public boolean updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getId())){
            repo.save(mapper.map(dto,Admin.class));
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() {
        List<Admin> admins = repo.findAll();
        return mapper.map(admins, new TypeToken<ArrayList<AdminDTO>>() {}.getType());
    }
}
