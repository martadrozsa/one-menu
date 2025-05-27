package com.denisczwicz.onemenu.infrastructure.database;

import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
