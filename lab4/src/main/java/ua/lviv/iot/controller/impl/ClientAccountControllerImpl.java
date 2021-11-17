package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.ClientAccountEntity;
import ua.lviv.iot.service.impl.ClientAccountServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class ClientAccountControllerImpl implements AbstractController<ClientAccountEntity> {
    ClientAccountServiceImpl service = new ClientAccountServiceImpl();

    @Override
    public List<ClientAccountEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ClientAccountEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ClientAccountEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, ClientAccountEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}