package com.denisczwicz.onemenu.entrypoint.mapper;

import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.entrypoint.dtos.UserRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserDTOMapper {

    private final AddressDTOMapper addressDTOMapper;

    public UserModel toModel(UserRequestDTO userRequestDTO) {
        return new UserModel(
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.password(),
                userRequestDTO.login(),
                userRequestDTO.address() != null ? addressDTOMapper.toModel(userRequestDTO.address()) : null);
    }
}
