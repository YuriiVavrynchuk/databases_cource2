package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ClientAccountDaoImpl;
import ua.lviv.iot.model.ClientAccountEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class ClientAccountServiceImpl implements AbstractService<ClientAccountEntity> {

    ClientAccountDaoImpl dao = new ClientAccountDaoImpl();

    @Override
    public List<ClientAccountEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ClientAccountEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(ClientAccountEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, ClientAccountEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}