package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.FeedbackEntity;
import ua.lviv.iot.service.impl.FeedbackServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class FeedbackControllerImpl implements AbstractController<FeedbackEntity> {
    FeedbackServiceImpl service = new FeedbackServiceImpl();

    @Override
    public List<FeedbackEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public FeedbackEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(FeedbackEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, FeedbackEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}