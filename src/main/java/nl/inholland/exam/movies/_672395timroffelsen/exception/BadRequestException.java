package nl.inholland.exam.movies._672395timroffelsen.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("The request was invalid or cannot be served.");
    }
    public BadRequestException(String msg) {
        super(msg);
    }
}
