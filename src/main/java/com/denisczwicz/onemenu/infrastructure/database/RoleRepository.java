package com.denisczwicz.onemenu.infrastructure.database;

import com.denisczwicz.onemenu.infrastructure.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

/**
 * RoleRepository is an interface that extends JpaRepository to provide CRUD operations for RoleEntity.
 * It includes methods to find roles by a set of permissions and count roles by permissions.
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findAllByPermissionIn(Set<String> permissions);

    Long countByPermissionIn(Set<String> permissions);
}
