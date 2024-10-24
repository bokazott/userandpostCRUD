package usersandpostsCRUD.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.UserDto;
import usersandpostsCRUD.demo.dto.UserResponseBody;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
    return userService.getUserById(id);
}
    @PostMapping
    public UserResponseBody createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserResponseBody updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

