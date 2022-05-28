package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Cancellation;

//DAO: Data Access Object: The object responsible for CRUD operations. It is basically an object that provides an interface to perform all database operations.

@Repository
//It is the actual implementation of DAO
//which simplify all the database operations.
//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.
public interface CancellationRepository extends CrudRepository<Cancellation, Integer> {
}
