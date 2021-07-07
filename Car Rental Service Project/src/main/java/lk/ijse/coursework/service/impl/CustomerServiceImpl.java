package lk.ijse.coursework.service.impl;


import lk.ijse.coursework.dto.CustomerDTO;
import lk.ijse.coursework.entity.Customer;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.repo.CustomerRepo;
import lk.ijse.coursework.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    private ModelMapper mapper;

    public boolean addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusID())) {
            throw new ValidateException("Customer Already Exist");
        }
        customerRepo.save(mapper.map(dto, Customer.class));
        return true;
    }

    public CustomerDTO searchCustomer( String id) {
        System.out.println(id+"service");
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }

        return null;
    }


    public boolean deleteCustomer(String id) {
        System.out.println(id+"service");

        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }

        customerRepo.deleteById(id);
        return true;
    }


    public boolean updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusID())){
            customerRepo.save(mapper.map(dto,Customer.class));
            return true;
        }

        return false;
    }

    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
        return mapper.map(allCustomers, new TypeToken<ArrayList<CustomerDTO>>() {}.getType());

    }
}
