public class InvalidNumberException extends RuntimeException{
    String message;

    public InvalidNumberException(String message) {
        super(message);

    }
}
