package org.iths.userservice2024.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        var user = userService.findByUserId(userId);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User ID not provided");
        }
        else return user;
    }
    @PostMapping
    void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/update/{userId}")
    void updateUser(@PathVariable String userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }
    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
    @GetMapping()
    List<User> getAllUsers() {
        return userService.findAll();
    }

}
