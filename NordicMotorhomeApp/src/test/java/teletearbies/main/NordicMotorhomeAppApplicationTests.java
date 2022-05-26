package teletearbies.main;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import teletearbies.entity.User;
import teletearbies.repository.UserRepository;

import java.util.Optional;

import teletearbies.entity.Booking;
import teletearbies.entity.Season;
import teletearbies.repository.BookingRepository;
import teletearbies.repository.SeasonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class NordicMotorhomeAppApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testAddingNewUser() {
        User user = new User("Bolly Shelly", "Talk person", "55512131669", "Shell", "1234");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

            @Test
            public void testListAll() {
                Iterable<User> users = userRepository.findAll();
                Assertions.assertThat(users).hasSizeGreaterThan(0);

                for (User user : users) {
                    System.out.println(user);
                }
            }

            @Test
            public void testUpdateUserPassword() {
                Integer userId = 1;
                Optional<User> optionalUser = userRepository.findById(userId);
                User user = optionalUser.get();
                user.setPassword("9999");
                userRepository.save(user);

                User updateUser = userRepository.findById(userId).get();
                Assertions.assertThat(updateUser.getPassword()).isEqualTo("9999");
            }

        @Test
        public void getAllSeasonsList() {
            Iterable<Season> allSeasons = seasonRepository.findAll();
            Assertions.assertThat(allSeasons).hasSizeGreaterThan(1);
        }

        @Test
        public void testDeleteUserPassword() {
            Integer userId = 1;

            Optional<User> optionalUser = userRepository.findById(userId);
            userRepository.deleteById(userId);

            Assertions.assertThat(optionalUser).isEmpty();
        }

        @Test
        public void getBookingById() {

            Integer userId = 1;
            Optional<Booking> bookings = bookingRepository.findById(userId);
            Assertions.assertThat(bookings).isPresent();
            System.out.println(bookings.get().toString());
        }

    }

