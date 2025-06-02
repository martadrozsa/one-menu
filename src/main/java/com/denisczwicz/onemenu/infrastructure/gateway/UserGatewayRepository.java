package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.domain.exception.UserNotFoundException;
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
import java.util.stream.Collectors;

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
        List<RoleEntity> rolesEntities = roleRepository.findAllByPermissionIn(userModel.roles());

        UserEntity userEntity = userMapper.toEntity(userModel);
        userEntity.setRoles(new HashSet<>(rolesEntities));

        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toModel(savedUser);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toModel)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Transactional
    @Override
    public UserModel updateUserProfile(UserModel userModel, Long id) {
        UserEntity foundUser = getUserEntity(id);
        foundUser.setName(userModel.name());
        foundUser.setEmail(userModel.email());

        AddressEntity address = foundUser.getAddress();
        addressMapper.updateAddressEntityFromModel(address, userModel.address());

        UserEntity savedUser = userRepository.save(foundUser);
        return userMapper.toModel(savedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        UserEntity user = getUserEntity(id);
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public UserModel updateCredentials(UserModel userModel, Long id) {
        UserEntity foundUser = getUserEntity(id);
        foundUser.setPassword(userModel.password());

        UserEntity savedUser = userRepository.save(foundUser);
        return userMapper.toModel(savedUser);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private UserEntity getUserEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

}
