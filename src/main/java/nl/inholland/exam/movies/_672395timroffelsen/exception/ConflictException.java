package nl.inholland.exam.movies._672395timroffelsen.exception;

public class ConflictException extends RuntimeException {
    public ConflictException() {
        super("There was a conflict processing your request.");
    }
    public ConflictException(String msg) {
        super(msg);
    }
}
