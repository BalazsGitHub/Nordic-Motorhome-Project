package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.User;
import teletearbies.repository.UserRepository;
import java.util.List;
import java.util.Optional;

//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class UserService {
    //enables us to inject object dependency implicitly. It internally uses setter, instance variable or constructor injection.
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUser(Integer id) throws UserNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any user with id: " + id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find user with id " + id);
        }
        userRepository.deleteById(id);
    }
}