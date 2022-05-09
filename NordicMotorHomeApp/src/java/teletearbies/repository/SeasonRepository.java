package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Brand;
import teletearbies.entity.Season;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Integer> {
}
