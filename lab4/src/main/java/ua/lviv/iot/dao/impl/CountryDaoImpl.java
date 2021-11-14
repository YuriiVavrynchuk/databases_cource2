package ua.lviv.iot.dao.impl;

import ua.lviv.iot.model.Country;

public class CountryDaoImpl extends AbstractDaoImpl<Country, Integer> {
    public CountryDaoImpl() {
        super(Country.class);
    }
}
