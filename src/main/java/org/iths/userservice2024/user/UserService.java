package org.iths.userservice2024.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Boolean isLoggedIn(String userId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) return false;
        return user.getLoggedIn();
    }

    public void updateUser(String userId, User user) {
       var existingUser = userRepository.findByUserId(userId);
       existingUser.setLoggedIn(user.getLoggedIn());
       existingUser.setPassword(user.getPassword());
       existingUser.setUsername(user.getUsername());
       userRepository.save(existingUser);
    }

    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }
}
