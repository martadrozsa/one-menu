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

import java.util.List;
import java.util.Optional;

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
    public UserModel updateProfileUser(UserModel userModel, Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
           return null;
        }

        UserEntity userEntity = foundUser.get();

        userEntity.setName(userModel.name());
        userEntity.setEmail(userModel.email());

        AddressEntity address = userEntity.getAddress();

        if(userModel.address().street() != null) {
            address.setStreet(userModel.address().street());
        }

        if(userModel.address().number() != null) {
            address.setNumber(userModel.address().number());
        }

        if(userModel.address().city() != null) {
            address.setCity(userModel.address().city());
        }

        if(userModel.address().state() != null) {
            address.setState(userModel.address().state());
        }

        if(userModel.address().country() != null) {
            address.setCountry(userModel.address().country());
        }

        if(userModel.address().postalCode() != null) {
            address.setPostalCode(userModel.address().postalCode());
        }

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

}
