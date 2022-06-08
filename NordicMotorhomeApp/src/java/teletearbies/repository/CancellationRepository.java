package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Cancellation;

//DAO: It is basically an object that provides an interface to perform all
// database operations (CrudRepository).


@Repository
//@Repository is more like a finder, it allows you to search for a specific type of objects, in this case Cancellation as well as store them.
//It is the actual implementation of the DAO.

//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.
public interface CancellationRepository extends CrudRepository<Cancellation, Integer> {
}
