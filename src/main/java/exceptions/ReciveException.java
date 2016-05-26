package exceptions;

public class ReciveException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ReciveException() {

    }

    public ReciveException(String message ) {
        super( message );
    }

    public ReciveException(String message, Exception e ) {
        super( message, e );
    }
}
