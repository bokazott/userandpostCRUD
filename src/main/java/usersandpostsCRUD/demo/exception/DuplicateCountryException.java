package usersandpostsCRUD.demo.exception;

public class DuplicateCountryException extends RuntimeException {
    public DuplicateCountryException(String countryName) {
        super(String.format("Country with name '%s' already exists",countryName));
    }
}
