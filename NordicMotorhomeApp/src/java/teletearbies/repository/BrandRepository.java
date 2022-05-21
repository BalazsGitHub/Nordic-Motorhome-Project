package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
 Brand findBrandByName(String name);
}
