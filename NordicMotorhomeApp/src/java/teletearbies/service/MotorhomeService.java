package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Motorhome;
import teletearbies.repository.MotorhomeRepository;

import java.util.List;

@Service
public class MotorhomeService {

    @Autowired
    private MotorhomeRepository motorhomeRepository;

    public void saveMotorhome(Motorhome motorhome) {
        motorhomeRepository.save(motorhome);
    }

    public Motorhome findById(int id) {
        return motorhomeRepository.findById(id).get();
    }

    public List<Motorhome> getAllMotorhomes() {
        return (List<Motorhome>) motorhomeRepository.findAll();
    }

}
