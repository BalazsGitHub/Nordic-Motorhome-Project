package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.User;

//DAO: It is basically an object that provides an interface to perform all
// database operations (CrudRepository).

@Repository
//DAO: It is basically an object that provides an interface to perform all
// database operations (CrudRepository).

//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.
public interface UserRepository extends CrudRepository<User, Integer> {

    //since interface methods are public, static, final by default, there's no need to use 'public' before the data type
     Long countById(Integer id);

     User findUserByUsername(String username);
}
