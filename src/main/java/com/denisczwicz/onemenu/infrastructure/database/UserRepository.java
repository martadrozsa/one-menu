package com.denisczwicz.onemenu.infrastructure.database;

import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByLoginAndPassword(String login, String password);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);
}
