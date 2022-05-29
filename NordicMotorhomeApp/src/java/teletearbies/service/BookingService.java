package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Booking;
import teletearbies.entity.Motorhome;
import teletearbies.repository.BookingRepository;
import java.util.List;
import java.util.Optional;
//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class BookingService {

    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
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


    public Booking getBooking(Integer id) throws BookingNotFoundException {
        Optional<Booking> result = bookingRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BookingNotFoundException("Could not find any Booking with id: " + id);
    }

    public void deleteBooking(Integer id) throws BookingNotFoundException {
        Long count = bookingRepository.countById(id);
        if (count == null || count == 0) {
            throw new BookingNotFoundException("Could not find Booking with id " + id);
        }
        bookingRepository.deleteById(id);
    }
}
