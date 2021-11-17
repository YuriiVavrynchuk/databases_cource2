package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.EventEntity;
import ua.lviv.iot.service.impl.EventServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class EventControllerImpl implements AbstractController<EventEntity> {
    EventServiceImpl service = new EventServiceImpl();

    @Override
    public List<EventEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public EventEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(EventEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, EventEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}