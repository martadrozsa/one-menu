package com.denisczwicz.onemenu.application.port;

import com.denisczwicz.onemenu.domain.model.AddressModel;

public interface AddressGatewayPort {

    void createAddress(AddressModel addressModel);
}
