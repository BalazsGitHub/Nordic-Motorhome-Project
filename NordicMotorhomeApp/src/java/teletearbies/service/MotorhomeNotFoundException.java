package teletearbies.service;

//our own customized exception class
//we extended the Throwable, which is the superclass of all exceptions.

public class MotorhomeNotFoundException extends Throwable {
    public MotorhomeNotFoundException(String message) {
        super(message);
    }

}
