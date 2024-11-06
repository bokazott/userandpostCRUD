package usersandpostsCRUD.demo.exception;

public class InvalidCountryDataException extends RuntimeException {
    public InvalidCountryDataException(String fieldName) {
        super(fieldName + " is required and cannot be null");
    }
}