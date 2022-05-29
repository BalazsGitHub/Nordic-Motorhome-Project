package teletearbies.service;

//our own customized exception class
//we extended the Throwable, which is the superclass of all exceptions.

public class NotFoundException extends Throwable {
    public NotFoundException(String message) {
        super(message);
    }
}
