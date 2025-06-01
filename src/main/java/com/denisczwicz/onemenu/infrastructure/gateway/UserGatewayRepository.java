package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.infrastructure.database.RoleRepository;
import com.denisczwicz.onemenu.infrastructure.database.UserRepository;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import com.denisczwicz.onemenu.infrastructure.database.entity.RoleEntity;
import com.denisczwicz.onemenu.infrastructure.database.entity.UserEntity;
import com.denisczwicz.onemenu.infrastructure.mapper.AddressMapper;
import com.denisczwicz.onemenu.infrastructure.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserGatewayRepository implements UserGatewayPort {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    @Transactional
    @Override
    public UserModel createUser(UserModel userModel) {
        List<RoleEntity> allByPermissionIn = roleRepository.findAllByPermissionIn(userModel.roles());

        UserEntity userEntity = userMapper.toEntity(userModel);
        userEntity.setRoles(new HashSet<>(allByPermissionIn));

        UserEntity savedUser = userRepository.save(userEntity);

        return userMapper.toModel(savedUser);
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
    public UserModel updateProfileUser(UserModel userModel, Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
           return null;
        }

        UserEntity userEntity = foundUser.get();

        userEntity.setName(userModel.name());
        userEntity.setEmail(userModel.email());

        AddressEntity address = userEntity.getAddress();

        addressMapper.updateAddressEntityFromModel(address, userModel.address());

        UserEntity save = userRepository.save(userEntity);

        return userMapper.toModel(save);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .ifPresent(userRepository::delete);

    }

    @Override
    public UserModel updateCredentials(UserModel userModel, Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
            return null;
        }

        UserEntity userEntity = foundUser.get();

        userEntity.setLogin(userModel.login());
        userEntity.setPassword(userModel.password());

        UserEntity save = userRepository.save(userEntity);

        return userMapper.toModel(save);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
