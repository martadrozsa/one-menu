package com.denisczwicz.onemenu.infrastructure.database;

import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository is an interface that extends JpaRepository to provide CRUD operations for UserEntity.
 * It includes methods to check if a user exists by login and password, login, or email.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByLoginAndPassword(String login, String password);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);
}
