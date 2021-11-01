package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ClientAccountDaoImpl;
import ua.lviv.iot.model.ClientAccount;

public class ClientAccountServiceImpl extends AbstractServiceImpl<ClientAccount, Integer> {
    public ClientAccountServiceImpl() {
        super(new ClientAccountDaoImpl());
    }
}
