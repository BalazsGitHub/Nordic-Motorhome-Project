package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Extra;
import teletearbies.repository.ExtraRepository;

import java.util.List;

@Service
public class ExtraService {

    @Autowired
    private ExtraRepository extraRepository;

    public void saveExtra(Extra extra) {
        extraRepository.save(extra);
    }

    public Extra findById(int id) {
        return extraRepository.findById(id).get();
    }

    public List<Extra> getAllExtras() {
        return (List<Extra>) extraRepository.findAll();
    }

    //public Extra findByName(String name){return brandRepository.findBrandByName(name);}
}
