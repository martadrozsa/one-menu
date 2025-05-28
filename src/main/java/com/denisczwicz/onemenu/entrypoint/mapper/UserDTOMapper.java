package com.denisczwicz.onemenu.entrypoint.mapper;

import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDTOMapper {

    private final AddressDTOMapper addressDTOMapper;

    public UserModel toModel(UserRequestDTO userRequestDTO) {
        return new UserModel(
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.login(),
                userRequestDTO.password(),
                userRequestDTO.address() != null ? addressDTOMapper.toModel(userRequestDTO.address()) : null);
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
