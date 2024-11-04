package usersandpostsCRUD.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("User with id %s does not exist",id));
    }
}


