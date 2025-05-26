package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.infrastructure.database.UserRepository;
import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import com.denisczwicz.onemenu.infrastructure.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toModel)
                .toList();
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toModel)
                .orElse(null);
    }

    @Override
    public UserModel updateUser(UserModel userModel, Long id) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    UserEntity updatedUser = userMapper.toEntity(userModel);
                    updatedUser.setId(existingUser.getId()); // Ensure the ID remains the same
                    return userMapper.toModel(userRepository.save(updatedUser));
                })
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .ifPresent(userRepository::delete);

    }

}
