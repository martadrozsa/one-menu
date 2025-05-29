package com.denisczwicz.onemenu.entrypoint.mapper;

import com.denisczwicz.onemenu.domain.model.AddressModel;
import com.denisczwicz.onemenu.entrypoint.dtos.request.AddressRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOMapper {

    public AddressModel toModel(AddressRequestDTO addressRequestDTO) {
        return AddressModel.builder()
                .street(addressRequestDTO.street())
                .number(addressRequestDTO.number())
                .city(addressRequestDTO.city())
                .state(addressRequestDTO.state())
                .country(addressRequestDTO.country())
                .postalCode(addressRequestDTO.postalCode())
                .build();

    }

    public AddressRequestDTO toRequestDTO(AddressModel addressModel) {
        return AddressRequestDTO.builder()
                .street(addressModel.street())
                .number(addressModel.number())
                .city(addressModel.city())
                .state(addressModel.state())
                .country(addressModel.country())
                .postalCode(addressModel.postalCode())
                .build();
    }
}
