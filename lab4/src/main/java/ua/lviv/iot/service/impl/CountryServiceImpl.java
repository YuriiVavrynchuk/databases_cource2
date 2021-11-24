package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.CountryEntity;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CountryServiceImpl implements AbstractService<CountryEntity> {

    CountryDaoImpl dao = new CountryDaoImpl();

    @Override
    public List<CountryEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CountryEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CountryEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CountryEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}