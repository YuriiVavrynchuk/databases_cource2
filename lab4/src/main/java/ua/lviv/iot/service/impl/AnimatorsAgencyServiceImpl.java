package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.AnimatorsAgencyDaoImpl;
import ua.lviv.iot.model.AnimatorsAgency;

public class AnimatorsAgencyServiceImpl extends AbstractServiceImpl<AnimatorsAgency, Integer> {
    public AnimatorsAgencyServiceImpl() {
        super(new AnimatorsAgencyDaoImpl());
    }
}
