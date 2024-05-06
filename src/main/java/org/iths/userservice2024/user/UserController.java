package org.iths.userservice2024.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    User getUser(String userId) {
        return userService.findByUserId(userId);
    }
    @PostMapping
    void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
    @GetMapping("/loggedin/{userId}")
    Boolean isLoggedIn(@PathVariable String userId) {
        return userService.isLoggedIn(userId);
    }
    @PutMapping("/update/{userId}")
    void updateUser(@PathVariable String userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }
    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
