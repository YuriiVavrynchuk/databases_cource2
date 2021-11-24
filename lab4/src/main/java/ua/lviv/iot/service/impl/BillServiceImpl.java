package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.BillDaoImpl;
import ua.lviv.iot.model.BillEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class BillServiceImpl implements AbstractService<BillEntity> {

    BillDaoImpl dao = new BillDaoImpl();

    @Override
    public List<BillEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public BillEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(BillEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, BillEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}