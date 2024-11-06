package usersandpostsCRUD.demo.exception;

public class DuplicateCityException extends RuntimeException {
    public DuplicateCityException(String cityName,String countryName) {
        super(String.format("City with name '%s' already exists in country '%s'", cityName, countryName));
    }
}
