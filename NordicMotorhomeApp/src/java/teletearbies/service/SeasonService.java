package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Season;
import teletearbies.repository.SeasonRepository;

import java.util.List;

//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class SeasonService {
    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
    @Autowired
    private SeasonRepository seasonRepository;

    public void saveSeason(Season season) {
        seasonRepository.save(season);
    }

    public Season findById(int id) {
        return seasonRepository.findById(id).get();
    }

    public List<Season> getAllSeasons() {
        return (List<Season>) seasonRepository.findAll();
    }

}
