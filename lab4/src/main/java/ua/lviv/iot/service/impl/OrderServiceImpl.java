package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.OrderDaoImpl;
import ua.lviv.iot.model.OrderEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements AbstractService<OrderEntity> {

    OrderDaoImpl dao = new OrderDaoImpl();

    @Override
    public List<OrderEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public OrderEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(OrderEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, OrderEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}