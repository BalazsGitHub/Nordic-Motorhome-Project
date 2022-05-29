package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Motorhome;

//DAO: It is basically an object that provides an interface to perform all
// database operations (CrudRepository).

@Repository
//@Repository is more like a finder, it allows you to search for a specific type of objects, in this case Extra as well as store them.
//It is the actual implementation of the DAO.

//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.
public interface MotorhomeRepository extends CrudRepository<Motorhome, Integer> {

    //since interface methods are public, static, final by default, there's no need to use 'public' before the data type
    Long countById(Integer id);
}
