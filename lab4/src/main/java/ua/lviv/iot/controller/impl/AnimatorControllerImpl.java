package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.AnimatorEntity;
import ua.lviv.iot.service.impl.AnimatorServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class AnimatorControllerImpl implements AbstractController<AnimatorEntity> {
    AnimatorServiceImpl service = new AnimatorServiceImpl();

    @Override
    public List<AnimatorEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public AnimatorEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(AnimatorEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, AnimatorEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
