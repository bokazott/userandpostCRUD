package usersandpostsCRUD.demo.controller;

import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.UserRequestBody;
import usersandpostsCRUD.demo.dto.UserResponseBody;
import usersandpostsCRUD.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<UserResponseBody> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseBody getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/cities/{cityId}")
    public List<UserResponseBody> getUsersByCityId(@PathVariable Long cityId) {
        return userService.getUsersByCityId(cityId);
    }

    @GetMapping("/countries/{countryId}")
    public List<UserResponseBody> getUsersByCountryId(@PathVariable Long countryId) {
        return userService.getUsersByCountryId(countryId);
    }

    @PostMapping
    public UserResponseBody createUser(@RequestBody UserRequestBody userRequestBody) {
        return userService.createUser(userRequestBody);
    }

    @PutMapping("/{id}")
    public UserResponseBody updateUser(@PathVariable Long id, @RequestBody UserRequestBody userRequestBody) {
        return userService.updateUser(id, userRequestBody);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

