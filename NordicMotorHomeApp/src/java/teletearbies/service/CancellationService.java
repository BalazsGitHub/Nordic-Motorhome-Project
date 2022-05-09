package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Cancellation;
import teletearbies.repository.CancellationRepository;

import java.util.List;

@Service
public class CancellationService {

    @Autowired
    CancellationRepository cancellationRepository;

    public void saveBrand(Cancellation cancellation) {
        cancellationRepository.save(cancellation);
    }

    public Cancellation findById(int id) {
        return cancellationRepository.findById(id).get();
    }

    public List<Cancellation> getAllEmployees() {
        return (List<Cancellation>) cancellationRepository.findAll();
    }

}
