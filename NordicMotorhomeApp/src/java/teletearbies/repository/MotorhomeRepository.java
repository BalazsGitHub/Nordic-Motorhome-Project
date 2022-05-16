package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import teletearbies.entity.Motorhome;

public interface MotorhomeRepository extends CrudRepository<Motorhome, Integer> {
    Long countById(Integer id);
}
