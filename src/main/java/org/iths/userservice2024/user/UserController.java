package org.iths.userservice2024.user;

import org.springframework.web.bind.annotation.*;

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
    User getUser(UUID userId) {
        return userService.findByUserId(userId);
    }
    @PostMapping
    void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
    @GetMapping("/loggedin/{userId}")
    Boolean isLoggedIn(@PathVariable UUID userId) {
        return userService.isLoggedIn(userId);
    }
    @PutMapping("/update/{userId}")
    void updateUser(@PathVariable UUID userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }
    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }
    @GetMapping("/all")
    List<User> getAllUsers() {
        return userService.findAll();
    }

}
