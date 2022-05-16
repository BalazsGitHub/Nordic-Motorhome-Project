package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Motorhome;

@Repository
public interface MotorhomeRepository extends CrudRepository<Motorhome, Integer> {
    Long countById(Integer id);
}
