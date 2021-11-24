package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.AnimatorsAgencyEntity;
import ua.lviv.iot.service.impl.AnimatorsAgencyServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class AnimatorsAgencyControllerImpl implements AbstractController<AnimatorsAgencyEntity> {
    AnimatorsAgencyServiceImpl service = new AnimatorsAgencyServiceImpl();

    @Override
    public List<AnimatorsAgencyEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public AnimatorsAgencyEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(AnimatorsAgencyEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, AnimatorsAgencyEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}