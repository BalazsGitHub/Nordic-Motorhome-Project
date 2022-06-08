package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Booking;


//DAO: It is basically an object that provides an interface to perform all
// database operations (CrudRepository).

//Allows you to access the database (or rather database tables), with a couple of CRUD methods.
//@Repository is more like a finder, it allows you to search for a specific type of objects, in this case Booking as well as store them.
//It is the actual implementation of the DAO.
@Repository
//We extend the CrudRepository Interface which provides general CRUD functionalities such as retrieve/search/save/delete.
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    //since interface methods are public, static, final by default, there's no need to use 'public' before the data type

    //the below is a version of the count method that the CrudRepository offers, the count method has by default type Long
    Long countById(Integer id);
}
