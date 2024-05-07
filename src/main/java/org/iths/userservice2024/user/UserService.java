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

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String userId, User user) {
        var existingUser = userRepository.findByUserId(userId);
        existingUser.setName(user.getName());
        existingUser.setPictureLink(user.getPictureLink());
        userRepository.save(existingUser);
    }

    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
