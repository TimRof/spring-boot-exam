package nl.inholland.exam.movies._672395timroffelsen.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super("Internal server error.");
    }
    public InternalServerErrorException(String msg) {
        super(msg);
    }
}