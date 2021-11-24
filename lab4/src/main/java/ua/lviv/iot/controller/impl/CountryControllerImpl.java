package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.CountryEntity;
import ua.lviv.iot.service.impl.CountryServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class CountryControllerImpl implements AbstractController<CountryEntity> {
    CountryServiceImpl service = new CountryServiceImpl();

    @Override
    public List<CountryEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public CountryEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(CountryEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, CountryEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}