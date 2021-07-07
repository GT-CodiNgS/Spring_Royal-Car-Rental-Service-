package lk.ijse.coursework.service.impl;


import lk.ijse.coursework.dto.BookingDTO;
import lk.ijse.coursework.entity.Booking;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.repo.BookingRepo;
import lk.ijse.coursework.service.BookingService;
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
public class BookingServiceImpl implements BookingService {


    @Autowired
    BookingRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public boolean addBooking(BookingDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new ValidateException("Enter valid details");
        }
        repo.save(mapper.map(dto, Booking.class));
        return true;

    }

    @Override
    public BookingDTO searchBooking(String id) {
        Optional<Booking> booking = repo.findById(id);
        if (booking.isPresent()) {
            return mapper.map(booking.get(), BookingDTO.class);
        }

        return null;
    }

    @Override
    public boolean deleteBooking(String id) {

        if (!repo.existsById(id)) {
            throw new ValidateException("No Booking for Delete..!");
        }

        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateBooking(BookingDTO dto) {
        if (repo.existsById(dto.getId())){
            repo.save(mapper.map(dto,Booking.class));
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<BookingDTO> getAllBooking() {
        List<Booking> bookings = repo.findAll();
        return mapper.map(bookings, new TypeToken<ArrayList<BookingDTO>>() {}.getType());
    }

    @Override
    public ArrayList<BookingDTO> getPendingBookings(String id) {
        List<Booking> bookings = repo.findByPermissionEquals(id);
        return mapper.map(bookings, new TypeToken<ArrayList<BookingDTO>>() {}.getType());
    }

    @Override
    public List<BookingDTO> getBookingCount_ofDay(String id) {
        List<Booking> bookings = repo.findByPickupDateEquals(id);
        return mapper.map(bookings, new TypeToken<ArrayList<BookingDTO>>() {}.getType());
    }
}
