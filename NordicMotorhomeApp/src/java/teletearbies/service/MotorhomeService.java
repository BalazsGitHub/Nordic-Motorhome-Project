package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Motorhome;
import teletearbies.repository.MotorhomeRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Booking;
import teletearbies.entity.Motorhome;
import teletearbies.repository.BookingRepository;
import java.util.List;
import java.util.Optional;
//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class MotorhomeService {
    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
   @Autowired
    private MotorhomeRepository motorhomeRepository;

    public void saveMotorhome(Motorhome motorhome) {
        motorhomeRepository.save(motorhome);
    }

    public List<Motorhome> getAllMotorhomes() {
        return (List<Motorhome>) motorhomeRepository.findAll();
    }

    public Motorhome getMotorhome(Integer id) throws MotorhomeNotFoundException {
        Optional<Motorhome> result = motorhomeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MotorhomeNotFoundException("Could not find any Motorhome with id: " + id);
    }

    public void deleteMotorhome(Integer id) throws MotorhomeNotFoundException {
        Long count = motorhomeRepository.countById(id);
        if (count == null || count == 0) {
                throw new MotorhomeNotFoundException("Could not find Motorhome with id " + id);
            }
            motorhomeRepository.deleteById(id);
        }
    }
