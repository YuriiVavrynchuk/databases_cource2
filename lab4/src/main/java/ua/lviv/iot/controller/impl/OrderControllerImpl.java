package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.OrderEntity;
import ua.lviv.iot.service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class OrderControllerImpl implements AbstractController<OrderEntity> {
    OrderServiceImpl service = new OrderServiceImpl();

    @Override
    public List<OrderEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public OrderEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(OrderEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, OrderEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}