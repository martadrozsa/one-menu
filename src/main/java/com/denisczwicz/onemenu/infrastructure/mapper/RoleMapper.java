package com.denisczwicz.onemenu.infrastructure.mapper;

import com.denisczwicz.onemenu.infrastructure.database.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public Set<String> toModel(Set<RoleEntity> roleEntities) {

        return roleEntities.stream()
                .map(RoleEntity::getPermission)
                .collect(Collectors.toSet());

    }
}
