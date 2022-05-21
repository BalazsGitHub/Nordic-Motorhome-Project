package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Brand;
import teletearbies.entity.Extra;

@Repository
public interface ExtraRepository extends CrudRepository<Extra, Integer> {
    Extra findExtraByName(String name);
}
