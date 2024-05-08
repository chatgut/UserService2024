package org.iths.userservice2024.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public void createUser(Users users) {
        userRepository.save(users);
    }

    public void updateUser(String userId, Users users) {
        var existingUser = userRepository.findByUserId(userId);
        existingUser.setName(users.getName());
        existingUser.setPictureLink(users.getPictureLink());
        userRepository.save(existingUser);
    }

    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
