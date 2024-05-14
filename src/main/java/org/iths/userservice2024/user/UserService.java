package org.iths.userservice2024.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if(userRepository.findByUserId(users.getUserId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID already exists");
        }
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
