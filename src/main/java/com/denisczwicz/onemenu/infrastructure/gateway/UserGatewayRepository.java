package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.infrastructure.database.UserRepository;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import com.denisczwicz.onemenu.infrastructure.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserGatewayRepository implements UserGatewayPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void createUser(UserModel userModel) {


        UserEntity userEntity = userMapper.toEntity(userModel);

        userRepository.save(userEntity);

    }
}
