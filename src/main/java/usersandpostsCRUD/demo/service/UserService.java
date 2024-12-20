package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.UserRequestBody;
import usersandpostsCRUD.demo.dto.UserResponseBody;
import usersandpostsCRUD.demo.entity.City;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.exception.UserNotFoundException;
import usersandpostsCRUD.demo.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CityService cityService;
    @Autowired
    public UserService(UserRepository userRepository,CityService cityService)
    {
        this.userRepository = userRepository;
        this.cityService=cityService;
    }
    public User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException(userId));
    }

    // Get all users
    public Page<UserResponseBody> getAllUsers(int page, int size, boolean ascending) {
        Sort sort = ascending ? Sort.by("firstName").ascending() : Sort.by("firstName").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(this::mapToResponseBody);
    }

    public Page<UserResponseBody> getUsersByCityId(Long cityId, Pageable pageable) {
        return userRepository.findByCityId(cityId, pageable)
                .map(this::mapToResponseBody);
    }
    public Page<UserResponseBody> getUsersByCountryId(Long countryId, Pageable pageable) {
        return userRepository.findByCountryId(countryId, pageable)
                .map(this::mapToResponseBody);
    }
    // This is method to map User entity to UserResponseBody
    private UserResponseBody mapToResponseBody(User user){
        UserResponseBody responseBody=new UserResponseBody();
        responseBody.setId(user.getId());
        responseBody.setFirstName(user.getFirstName());
        responseBody.setLastName(user.getLastName());
        return responseBody;
    }
    //Get user by id
    public UserResponseBody getUserById(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return mapToResponseBody(user);
    }


    //Create user with DTO
    public UserResponseBody createUser(UserRequestBody userRequestBody) {
        User user=new User();
        user.setFirstName(userRequestBody.getFirstName());
        user.setLastName(userRequestBody.getLastName());
        user.setAge(userRequestBody.getAge());
        user.setHeight(userRequestBody.getHeight());
        user.setWeight(userRequestBody.getWeight());
        user.setEmail(userRequestBody.getEmail());
        user.setPhoneNumber(userRequestBody.getPhoneNumber());

        City city=cityService.findCityById(userRequestBody.getCityId());
        user.setCity(city);


        User userOdBaza = userRepository.save(user);

        UserResponseBody userSoKeGovratamNazad = new UserResponseBody();
        userSoKeGovratamNazad.setFirstName(userOdBaza.getFirstName());
        userSoKeGovratamNazad.setLastName(userOdBaza.getLastName());
        userSoKeGovratamNazad.setId(userOdBaza.getId());
        return userSoKeGovratamNazad;
    }
//Update user with DTO
    public UserResponseBody updateUser(Long id, UserRequestBody userRequestBody) {
        return userRepository.findById(id).map(user -> {
            if (userRequestBody.getFirstName() != null) {
                user.setFirstName(userRequestBody.getFirstName());
            }
            if (userRequestBody.getLastName() != null) {
                user.setLastName(userRequestBody.getLastName());
            }
            if (userRequestBody.getAge() != null) {
                user.setAge(userRequestBody.getAge());
            }
            if (userRequestBody.getWeight() != null) {
                user.setWeight(userRequestBody.getWeight());
            }
            if (userRequestBody.getHeight() != null) {
                user.setHeight(userRequestBody.getHeight());
            }
            if (userRequestBody.getEmail() != null) {
                user.setEmail(userRequestBody.getEmail());
            }
            if (userRequestBody.getPhoneNumber() != null) {
                user.setPhoneNumber(userRequestBody.getPhoneNumber());
            }
            User updatedUser = userRepository.save(user);
            UserResponseBody response = new UserResponseBody();
            response.setId(updatedUser.getId());
            response.setFirstName(updatedUser.getFirstName());
            response.setLastName(updatedUser.getLastName());
            return response;
        }).orElseThrow(() -> new UserNotFoundException(id));
    }
//Delete user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
