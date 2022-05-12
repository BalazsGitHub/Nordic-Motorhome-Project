package teletearbies.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import teletearbies.entity.Cancellation;
        import teletearbies.entity.Season;
        import teletearbies.repository.SeasonRepository;

        import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;

    public void saveSeason(Season season) {
        seasonRepository.save(season);
    }

    public Season findById(int id) {
        return seasonRepository.findById(id).get();
    }

    public List<Season> getAll() {
        return (List<Season>) seasonRepository.findAll();
    }

}
