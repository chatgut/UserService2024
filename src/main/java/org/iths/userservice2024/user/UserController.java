package org.iths.userservice2024.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    Users getUser(@PathVariable String userId) {
        var user = userService.findByUserId(userId);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User ID not provided");
        }
        else return user;
    }
    @PostMapping
    void createUser(@RequestBody Users users) {
        userService.createUser(users);
    }

    @PutMapping("/update/{userId}")
    void updateUser(@PathVariable String userId, @RequestBody Users users) {
        userService.updateUser(userId, users);
    }
    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
    @GetMapping()
    List<Users> getAllUsers() {
        return userService.findAll();
    }

}
