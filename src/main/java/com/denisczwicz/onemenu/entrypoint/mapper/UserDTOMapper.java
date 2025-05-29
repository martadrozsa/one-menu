package com.denisczwicz.onemenu.entrypoint.mapper;

import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.entrypoint.dtos.request.CreateUserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UpdateUserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDTOMapper {

    private final AddressDTOMapper addressDTOMapper;

    public UserModel toModel(CreateUserRequestDTO createUserRequestDTO) {
        return UserModel.builder()
                .name(createUserRequestDTO.name())
                .email(createUserRequestDTO.email())
                .login(createUserRequestDTO.login())
                .password(createUserRequestDTO.password())
                .address(addressDTOMapper.toModel(createUserRequestDTO.address()))
                .build();
    }

    public UserModel toModel(UpdateUserRequestDTO updateUserRequestDTO) {
        return UserModel.builder()
                .name(updateUserRequestDTO.name())
                .email(updateUserRequestDTO.email())
                .address(addressDTOMapper.toModel(updateUserRequestDTO.address()))
                .build();
    }


    public UserResponseDTO toResponseDTO(UserModel userModel) {
        return UserResponseDTO.builder()
                .name(userModel.name())
                .email(userModel.email())
                .login(userModel.login())
                .password(userModel.password())
                .address(addressDTOMapper.toRequestDTO(userModel.address()))
                .build();
    }
}
