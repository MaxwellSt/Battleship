package exceptions;

public class SendException extends Exception {

    private static final long serialVersionUID = 1L;

    public SendException() {

    }

    public SendException(String message ) {
        super( message );
    }
    
    public SendException(String message, Exception e ) {
        super( message, e );
    }

}
