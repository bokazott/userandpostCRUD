package usersandpostsCRUD.demo.exception;

public class InvalidCityDataException extends RuntimeException {
    public InvalidCityDataException(String fieldName) {
        super(fieldName + " is required and cannot be null");
    }
}
