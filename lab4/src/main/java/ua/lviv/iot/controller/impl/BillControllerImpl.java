package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.BillEntity;
import ua.lviv.iot.service.impl.BillServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class BillControllerImpl implements AbstractController<BillEntity> {
    BillServiceImpl service = new BillServiceImpl();

    @Override
    public List<BillEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public BillEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(BillEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, BillEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}