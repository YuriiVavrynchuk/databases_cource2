package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.AnimatorsAgencyDaoImpl;
import ua.lviv.iot.model.AnimatorsAgencyEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AnimatorsAgencyServiceImpl implements AbstractService<AnimatorsAgencyEntity> {

    AnimatorsAgencyDaoImpl dao = new AnimatorsAgencyDaoImpl();

    @Override
    public List<AnimatorsAgencyEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public AnimatorsAgencyEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(AnimatorsAgencyEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, AnimatorsAgencyEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}