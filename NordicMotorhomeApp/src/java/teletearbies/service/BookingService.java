package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Booking;
import teletearbies.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking findById(int id) {
        return bookingRepository.findById(id).get();
    }

    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }
}
