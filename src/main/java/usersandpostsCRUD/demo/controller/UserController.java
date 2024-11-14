package usersandpostsCRUD.demo.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<UserResponseBody> getAllUsers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "true") boolean ascending) {
        return userService.getAllUsers(page, size, ascending);
    }

    @GetMapping("/{id}")
    public UserResponseBody getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/cities/{cityId}")
    public Page<UserResponseBody> getUsersByCityId(
            @PathVariable Long cityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getUsersByCityId(cityId, pageable);
    }

    @GetMapping("/countries/{countryId}")
    public Page<UserResponseBody> getUsersByCountryId(
            @PathVariable Long countryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return userService.getUsersByCountryId(countryId, pageable);
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

