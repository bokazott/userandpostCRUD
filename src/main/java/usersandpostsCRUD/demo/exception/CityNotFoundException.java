package usersandpostsCRUD.demo.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Long id){
        super(String.format("City with id %s is not found"));
    }
}