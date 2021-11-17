package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.FeedbackDaoImpl;
import ua.lviv.iot.model.FeedbackEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class FeedbackServiceImpl implements AbstractService<FeedbackEntity> {

    FeedbackDaoImpl dao = new FeedbackDaoImpl();

    @Override
    public List<FeedbackEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public FeedbackEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(FeedbackEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, FeedbackEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}