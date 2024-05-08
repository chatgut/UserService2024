package org.iths.userservice2024.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.userId = ?1")
    Users findByUserId(String userId);

    @Query("DELETE FROM Users u WHERE u.userId = ?1")
    void deleteByUserId(String userId);
}