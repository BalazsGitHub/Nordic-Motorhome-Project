package teletearbies.service;

//our own customized exception class
//we extended the Throwable, which is the superclass of all exceptions.

public class BookingNotFoundException extends Throwable{

    //We use a String message as a parameter, because we want to display specific error messages when implementing this method.
    public BookingNotFoundException(String message) {
        super(message);
    }
}
