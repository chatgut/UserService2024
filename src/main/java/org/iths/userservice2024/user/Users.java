package org.iths.userservice2024.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    private String userId;
    private String name;
    private String pictureLink="https://cdn.starwebserver.se/shops/ksl-trading-ab/files/4500.jpg";

    public Users() {
    }

    public Users(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Users(String userId, String name, String pictureLink) {
        this.userId = userId;
        this.name = name;
        this.pictureLink = pictureLink;
    }
}
