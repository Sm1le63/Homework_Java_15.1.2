package exception;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String msg) {
        super(msg);
    }
}