package usersandpostsCRUD.demo.exception;

public class DuplicateCityException extends RuntimeException {
    public DuplicateCityException(String message) {
        super(message);
    }
}
