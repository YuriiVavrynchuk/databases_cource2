package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.EventDaoImpl;
import ua.lviv.iot.model.EventEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class EventServiceImpl implements AbstractService<EventEntity> {

    EventDaoImpl dao = new EventDaoImpl();

    @Override
    public List<EventEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public EventEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(EventEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, EventEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}