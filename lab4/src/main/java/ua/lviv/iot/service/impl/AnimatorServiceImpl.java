package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.AnimatorDaoImpl;
import ua.lviv.iot.model.AnimatorEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AnimatorServiceImpl implements AbstractService<AnimatorEntity> {

    AnimatorDaoImpl dao = new AnimatorDaoImpl();

    @Override
    public List<AnimatorEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public AnimatorEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(AnimatorEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, AnimatorEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
