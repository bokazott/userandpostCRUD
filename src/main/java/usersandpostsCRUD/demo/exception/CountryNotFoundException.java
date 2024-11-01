package usersandpostsCRUD.demo.exception;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id){
        super(String.format("Country with id %s is not found"));
    }
}
