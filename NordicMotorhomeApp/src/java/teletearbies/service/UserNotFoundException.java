package teletearbies.service;

//our own customized exception class
//we extended the Throwable, which is the superclass of all exceptions.

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}
