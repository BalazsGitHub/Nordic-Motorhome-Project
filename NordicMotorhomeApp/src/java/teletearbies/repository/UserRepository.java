package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

    public User findUserByUsername(String username);
}
