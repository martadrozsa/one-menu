package com.denisczwicz.onemenu.infrastructure.database;

import com.denisczwicz.onemenu.infrastructure.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findAllByPermissionIn(Set<String> permissions);

    Long countByPermissionIn(Set<String> permissions);
}
