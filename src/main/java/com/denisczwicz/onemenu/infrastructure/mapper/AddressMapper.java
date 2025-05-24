package com.denisczwicz.onemenu.infrastructure.mapper;

import com.denisczwicz.onemenu.domain.model.AddressModel;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressEntity toEntity(AddressModel addressModel) {
        return AddressEntity.builder()
                .street(addressModel.street())
                .number(addressModel.number())
                .city(addressModel.city())
                .state(addressModel.state())
                .country(addressModel.country())
                .postalCode(addressModel.postalCode())
                .build();
    }
}
