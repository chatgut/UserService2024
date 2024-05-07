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
    private String userId;
    private String name;
    private String pictureLink="https://cdn.starwebserver.se/shops/ksl-trading-ab/files/4500.jpg";

    public User() {
    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User(String userId, String name, String pictureLink) {
        this.userId = userId;
        this.name = name;
        this.pictureLink = pictureLink;
    }
}
