package org.iths.userservice2024.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends ListCrudRepository<Users, String> {
    @Query("SELECT u FROM Users u WHERE u.userId = :userId")
    Users findByUserId(@Param("userId")String userId);

    @Modifying
    @Query("DELETE FROM Users u WHERE u.userId = :userId")
    void deleteByUserId(@Param("userId") String userId);

}