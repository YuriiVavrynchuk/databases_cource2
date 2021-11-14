package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.Country;

public class CountryServiceImpl extends AbstractServiceImpl<Country, Integer> {
    public CountryServiceImpl() {
        super(new CountryDaoImpl());
    }
}
