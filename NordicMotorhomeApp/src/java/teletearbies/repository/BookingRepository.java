package teletearbies.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Booking;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
    Long countById(Integer id);

    //@Query(value = "from Booking t where start_date BETWEEN :startDate AND :endDate")
    //List<Booking> findByColumnDateBetween(LocalDate startDate, LocalDate endDate);

}
