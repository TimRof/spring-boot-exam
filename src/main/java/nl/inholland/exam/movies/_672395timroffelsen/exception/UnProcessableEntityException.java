package nl.inholland.exam.movies._672395timroffelsen.exception;

public class UnProcessableEntityException extends RuntimeException {
    public UnProcessableEntityException() {
        super("Unprocessable entity.");
    }
    public UnProcessableEntityException(String msg) {
        super(msg);
    }
}
