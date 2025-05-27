package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.AddressGatewayPort;
import com.denisczwicz.onemenu.domain.model.AddressModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressGatewayRepository implements AddressGatewayPort {

    @Override
    public void createAddress(AddressModel addressModel) {

    }
}
