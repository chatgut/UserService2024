package org.iths.userservice2024.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    User findByUserId(UUID userId);

    @Query("DELETE FROM User u WHERE u.userId = ?1")
    void deleteByUserId(UUID userId);
}
