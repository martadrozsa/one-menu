package com.denisczwicz.onemenu.infrastructure.mapper;

import com.denisczwicz.onemenu.domain.model.AddressModel;
import com.denisczwicz.onemenu.infrastructure.database.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressMapper {

    public List<AddressEntity> toEntity(List<AddressModel> addressModels) {
        return addressModels.stream()
                .map(addressModel -> AddressEntity.builder()
                        .street(addressModel.street())
                        .number(addressModel.number())
                        .city(addressModel.city())
                        .state(addressModel.state())
                        .country(addressModel.country())
                        .postalCode(addressModel.postalCode())
                        .build())
                .collect(Collectors.toList());
    }
}
