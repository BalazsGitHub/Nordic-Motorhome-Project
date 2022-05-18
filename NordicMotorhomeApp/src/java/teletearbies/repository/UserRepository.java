package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Long countById(Integer id);
}