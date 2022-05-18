package teletearbies.service;

public class BookingNotFoundException extends Throwable{
    public BookingNotFoundException(String message) {
        super(message);
    }
}
