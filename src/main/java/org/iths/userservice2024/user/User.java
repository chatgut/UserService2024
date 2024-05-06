package org.iths.userservice2024.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userId;
    private String username;
    private String password;
    private Boolean loggedIn = false;

    public User() {
    }

    public UUID getUserId() {
        return UUID.randomUUID();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
