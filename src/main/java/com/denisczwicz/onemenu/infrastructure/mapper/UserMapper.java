package com.denisczwicz.onemenu.infrastructure.mapper;

import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final AddressMapper addressMapper;

    public UserEntity toEntity(UserModel userModel) {
        AddressEntity addressEntity = addressMapper.toEntity(userModel.address());

        UserEntity userEntity = UserEntity.builder()
                .name(userModel.name())
                .email(userModel.email())
                .password(userModel.password())
                .login(userModel.login())
                .address(addressEntity)
                .build();

        addressEntity.setUser(userEntity);

        return userEntity;
    }
}
