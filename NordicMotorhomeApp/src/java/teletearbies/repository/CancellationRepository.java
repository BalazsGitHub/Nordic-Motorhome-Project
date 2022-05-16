package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Cancellation;

@Repository
public interface CancellationRepository extends CrudRepository<Cancellation, Integer> {
}
