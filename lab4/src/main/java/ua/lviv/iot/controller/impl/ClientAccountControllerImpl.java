package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.ClientAccount;
import ua.lviv.iot.service.impl.ClientAccountServiceImpl;

public class ClientAccountControllerImpl extends AbstractControllerImpl<ClientAccount, Integer> {
    public ClientAccountControllerImpl() {
        super(new ClientAccountServiceImpl());
    }
}
