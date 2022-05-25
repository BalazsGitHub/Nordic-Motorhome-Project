package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
    Long countById(Integer id);

}
