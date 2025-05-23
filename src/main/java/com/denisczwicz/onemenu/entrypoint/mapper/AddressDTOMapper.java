package com.denisczwicz.onemenu.entrypoint.mapper;

import com.denisczwicz.onemenu.domain.model.AddressModel;
import com.denisczwicz.onemenu.entrypoint.dtos.AddressRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOMapper {

    public AddressModel toModel(AddressRequestDTO addressRequestDTO) {

        return new AddressModel(
                addressRequestDTO.street(),
                addressRequestDTO.number(),
                addressRequestDTO.city(),
                addressRequestDTO.state(),
                addressRequestDTO.country(),
                addressRequestDTO.postalCode()
        );
    }
}
