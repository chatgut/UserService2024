package org.iths.userservice2024.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserId(UUID userId) {
        return userRepository.findByUserId(userId);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Boolean isLoggedIn(UUID userId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) return false;
        return user.getLoggedIn();
    }

    public void updateUser(UUID userId, User user) {
       var existingUser = userRepository.findByUserId(userId);
       existingUser.setLoggedIn(user.getLoggedIn());
       existingUser.setPassword(user.getPassword());
       existingUser.setUsername(user.getUsername());
       userRepository.save(existingUser);
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteByUserId(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
