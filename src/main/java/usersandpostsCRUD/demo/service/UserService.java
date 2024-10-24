package usersandpostsCRUD.demo.service;

import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.UserDto;
import usersandpostsCRUD.demo.dto.UserResponseBody;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.exception.UserNotFoundException;
import usersandpostsCRUD.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    public UserResponseBody createUser(UserDto userDto) {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        User userOdBaza = userRepository.save(user);

        UserResponseBody userSoKeGovratamNazad = new UserResponseBody();
        userSoKeGovratamNazad.setFistName(userOdBaza.getFirstName());
        userSoKeGovratamNazad.setLast(userOdBaza.getLastName());
        userSoKeGovratamNazad.setId(userOdBaza.getId());
        return userSoKeGovratamNazad;
    }

    public UserResponseBody updateUser(Long id, UserDto userDto) {
        return userRepository.findById(id).map(user -> {
            if (userDto.getFirstName() != null) {
                user.setFirstName(userDto.getFirstName());
            }
            if (userDto.getLastName() != null) {
                user.setLastName(userDto.getLastName());
            }
            if (userDto.getAge() != null) {
                user.setAge(userDto.getAge());
            }
            if (userDto.getWeight() != null) {
                user.setWeight(userDto.getWeight());
            }
            if (userDto.getHeight() != null) {
                user.setHeight(userDto.getHeight());
            }
            if (userDto.getEmail() != null) {
                user.setEmail(userDto.getEmail());
            }
            if (userDto.getPhoneNumber() != null) {
                user.setPhoneNumber(userDto.getPhoneNumber());
            }
            User updatedUser = userRepository.save(user);
            UserResponseBody response = new UserResponseBody();
            response.setId(updatedUser.getId());
            response.setFistName(updatedUser.getFirstName());
            response.setLast(updatedUser.getLastName());
            return response;
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
