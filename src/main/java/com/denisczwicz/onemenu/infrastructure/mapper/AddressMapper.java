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

    public AddressModel toModel(AddressEntity addressEntity) {
        return new AddressModel(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getCountry(),
                addressEntity.getPostalCode()
        );
    }

    public void updateAddressEntityFromModel(AddressEntity address, AddressModel addressModel) {
        if (addressModel.street() != null) {
            address.setStreet(addressModel.street());
        }
        if (addressModel.number() != null) {
            address.setNumber(addressModel.number());
        }
        if (addressModel.city() != null) {
            address.setCity(addressModel.city());
        }
        if (addressModel.state() != null) {
            address.setState(addressModel.state());
        }
        if (addressModel.country() != null) {
            address.setCountry(addressModel.country());
        }
        if (addressModel.postalCode() != null) {
            address.setPostalCode(addressModel.postalCode());
        }
    }
}
