package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.impl.CountryServiceImpl;

public class CountryControllerImpl extends AbstractControllerImpl<Country, Integer> {
    public CountryControllerImpl() {
        super(new CountryServiceImpl());
    }
}
