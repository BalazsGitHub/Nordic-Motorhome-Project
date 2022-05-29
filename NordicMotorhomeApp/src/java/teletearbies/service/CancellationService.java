package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Cancellation;
import teletearbies.repository.CancellationRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Booking;
import teletearbies.entity.Motorhome;
import teletearbies.repository.BookingRepository;
import java.util.List;
import java.util.Optional;
//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class CancellationService {
    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
    @Autowired
    private CancellationRepository cancellationRepository;

    public void saveCancellation(Cancellation cancellation) {
        cancellationRepository.save(cancellation);
    }

    public Cancellation findById(int id) {
        return cancellationRepository.findById(id).get();
    }

    public List<Cancellation> getAllCancellations() {
        return (List<Cancellation>) cancellationRepository.findAll();
    }

}
