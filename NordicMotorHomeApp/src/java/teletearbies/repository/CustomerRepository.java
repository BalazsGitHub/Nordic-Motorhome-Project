package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
