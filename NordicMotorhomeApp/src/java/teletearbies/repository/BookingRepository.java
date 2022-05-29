package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Booking;


//DAO: It is basically an object that provides an interface to perform all database operations.

@Repository
//@Repository
//repository
//which simplify all the database operations.
//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    //since interface methods are public, static, final by default, there's no need to use 'public' before the data type

    //the below method is a customization/gathering of the methods, and therefore the id passed is an integer, the count method has by default type Long
    Long countById(Integer id);
}
