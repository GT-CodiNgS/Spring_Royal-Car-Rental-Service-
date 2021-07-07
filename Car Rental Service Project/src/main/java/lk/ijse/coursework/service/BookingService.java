package lk.ijse.coursework.service;


import lk.ijse.coursework.dto.BookingDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
public interface BookingService {
    boolean addBooking(BookingDTO dto);

    BookingDTO searchBooking(String id);

    boolean deleteBooking(String id);

    boolean updateBooking(BookingDTO dto);

    ArrayList<BookingDTO> getAllBooking();

//    *************

    List<BookingDTO> getPendingBookings(String id);
    List<BookingDTO> getBookingCount_ofDay(String id);

}
