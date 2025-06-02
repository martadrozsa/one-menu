package com.denisczwicz.onemenu.infrastructure.mapper;

import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final AddressMapper addressMapper;
    private final RoleMapper roleMapper;

    public UserEntity toEntity(UserModel userModel) {
        AddressEntity addressEntity = addressMapper.toEntity(userModel.address());

        UserEntity userEntity = UserEntity.builder()
                .name(userModel.name())
                .email(userModel.email())
                .login(userModel.login())
                .password(userModel.password())
                .address(addressEntity)
                .roles(Set.of())
                .build();

        addressEntity.setUser(userEntity);

        return userEntity;
    }

    public UserModel toModel(UserEntity userEntity) {
        return new UserModel(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                addressMapper.toModel(userEntity.getAddress()),
                roleMapper.toModel(userEntity.getRoles())
        );
    }
}
