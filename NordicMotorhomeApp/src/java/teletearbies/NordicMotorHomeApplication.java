package teletearbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This annotation enables us to use annotation driven injection in our application.
// When we run our application, it will automatically scan the components in the current package
//and sub-packages and it will register them in springs application context and allow us to inject
//beans using @Autowired.
@SpringBootApplication
public class NordicMotorHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NordicMotorHomeApplication.class, args);
    }
}
